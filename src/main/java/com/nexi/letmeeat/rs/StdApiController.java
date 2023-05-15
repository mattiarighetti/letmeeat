package com.nexi.letmeeat.rs;

import com.nexi.letmeeat.db.*;
import com.nexi.letmeeat.model.*;
import com.nexi.letmeeat.resoruces.*;
import com.nexi.letmeeat.services.PayPalService;
import com.nexi.letmeeat.services.XPayService;
import com.nexi.letmeeat.utils.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class StdApiController implements StdApi {

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PayPalService payPalService;

    @Autowired
    private XPayService xPayService;

    @Override
    public ResponseEntity<PaymentRedirectResponse> postOrder(OrderModel orderModel, HttpServletRequest request) throws IOException {

        Optional<Seat> seat = seatRepository.findById(orderModel.getSeatId());
        List<Dish> dishes = dishRepository.findDishesByDishIdIn(orderModel.getDishIds());
        User user = userRepository.findById(orderModel.getUserId()).orElse(null);

        if (!seat.isPresent() || dishes.isEmpty())
            return ResponseEntity.badRequest().build();

        Order order = Order.builder().seat(seat.get()).dishes(dishes)
                .user(user).
                status(Order.Status.PENDING.name()).build();

        orderRepository.save(order);

        Double amount = order.getDishes().stream().mapToDouble(Dish::getPrice).reduce(0, Double::sum);
        PaymentRedirectResponse paymentRedirectResponse;
        if (orderModel.getType() == 1) {
            paymentRedirectResponse = payPalService.createOrder(amount, order.getUser().getUserId(), orderModel.getSeatId(), order.getOrderId(), order.getSeat().getTables().getRestaurant().getName(), request);
        } else {
            CustomerInfo customerInfo = CustomerInfo.builder()
                    .cardHolderName(order.getUser().getName())
                    .cardHolderEmail(order.getUser().getEmail())
                    .mobilePhone("3380402457")
                    .build();
            Recurrence recurrence = Recurrence.builder()
                    .action("NO_RECURRING")
                    .contractId(UUID.randomUUID().toString().substring(1, 15))
                    .contractType("MIT_UNSCHEDULED")
                    .build();
            PaymentSession paymentSession = PaymentSession.builder()
                    .actionType("PAY")
                    .amount((long) (amount * 100))
                    .recurrence(recurrence)
                    .captureType("IMPLICIT")
                    .exemptions("NO_PREFERENCE")
                    .language("ita")
                    .notificationUrl("https://letmeeat2.osc-fr1.scalingo.io/payment/success")
                    .paymentService("CARDS")
                    .build();
            XPayOrder xPayOrder = XPayOrder.builder()
                    .orderId(UUID.randomUUID().toString().substring(0, 25))
                    .amount((long) (amount * 100))
                    .currency("EUR")
                    .customerId(order.getSeat().getTables().getRestaurant().getRestaurantId().toString())
                    .description(order.getSeat().getTables().getRestaurant().getRestaurantId().toString())
                    .customField("")
                    .customerInfo(customerInfo)
                    .build();
            PayByLinkRequest payByLinkRequest = PayByLinkRequest.builder()
                    .order(xPayOrder)
                    .paymentSession(paymentSession)
                    .expirationDate("2023-05-31")
                    .build();

            paymentRedirectResponse = xPayService.payByLink(payByLinkRequest, order.getUser().getUserId(), orderModel.getSeatId(), order.getOrderId(), order.getSeat().getTables().getRestaurant().getName(), amount);
        }
        return ResponseEntity.ok(paymentRedirectResponse);
    }

    @Override
    public ResponseEntity<BookingConfirmation> postBooking(PostBookingRequest postBookingRequest) {

        Booking booking = Booking.builder()
                .table(tableRepository.findById(postBookingRequest.getTableId()).orElse(null))
                .user(userRepository.findById(postBookingRequest.getUserId()).orElse(null))
                .restaurant(restaurantRepository.findById(postBookingRequest.getRestaurantId()).orElse(null))
                .bookingDate(new Date())
                .build();
        bookingRepository.save(booking);
        return ResponseEntity.ok(new BookingConfirmation(booking.getBookingDate()));
    }

    @Override
    public ResponseEntity<List<Restaurant>> getRestaurant(Long userId) {
        if (ObjectUtils.isEmpty(userId)) {
            return new ResponseEntity<>(restaurantRepository.findAll(), HttpStatus.OK);
        } else {
            List<Restaurant> restaurants = restaurantRepository.findAll();
            restaurants.forEach(restaurant -> restaurant.setBookings(restaurant.getBookings().stream().filter(booking -> booking.getUser().getUserId().equals(userId)).collect(Collectors.toList())));
            return new ResponseEntity<>(restaurants, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Menu> getRestaurantMenu(String restaurantId) {
        return ResponseEntity.ok(menuRepository.findMenuByRestaurantId(restaurantId));
    }

    @Override
    public ResponseEntity<List<Tables>> getRestaurantTables(String restaurantId) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(Long.parseLong(restaurantId));
        return ResponseEntity.ok(tableRepository.findTablesByRestaurant(restaurant));
    }

    @Override
    public ResponseEntity<List<User>> getUser() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Payment>> getUserPayments(String userId) {
        User user = new User();
        user.setUserId(Long.parseLong(userId));
        return ResponseEntity.ok(paymentRepository.findPaymentsByUser(user));
    }

    @Override
    public ResponseEntity<List<Booking>> getUserBookings(String userId) {
        User user = new User();
        user.setUserId(Long.parseLong(userId));
        List<Booking> bookings = bookingRepository.findBookingByUser(user);
        bookings.forEach(booking -> booking.setRestaurantName(
                booking.getRestaurant().getName()));
        return ResponseEntity.ok(bookings);
    }

    @Override
    public ResponseEntity<List<Order>> getOrder() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<String> paymentSuccess(@RequestParam String orderId) {

        Order order = orderRepository.findById(Long.parseLong(orderId)).orElse(null);

        if (order != null) {
            emailService.sendEmail(order);
            HttpHeaders headers = new HttpHeaders();
            headers.set("Location", "https://letmeeat2.osc-fr1.scalingo.io/close");
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Payment>> payment(Long userId) {

        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent())
            return ResponseEntity.badRequest().build();

        log.info("User {}", user);

        user.get().getPayments().forEach(
                payment -> {
                    try {
                        log.info("Order id {}", payment.getOrderId());
                        Optional<Order> order = orderRepository.findById(payment.getOrderId());
                        log.info("Order {}", order);
                        String receipt =  emailService.buildReceipt(order.get());
                        log.info("Receipt {}", order);
                        payment.setReceipt(receipt);
                    } catch (Exception e) {
                        log.error("Error during setting receipt", e);
                    }
                }
        );

        return ResponseEntity.ok(user.get().getPayments());
    }

}
