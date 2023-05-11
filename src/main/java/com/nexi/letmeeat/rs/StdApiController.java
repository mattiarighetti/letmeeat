package com.nexi.letmeeat.rs;

import com.nexi.letmeeat.db.*;
import com.nexi.letmeeat.model.*;
import com.nexi.letmeeat.resoruces.CreateOrderResponse;
import com.nexi.letmeeat.resoruces.OrderModel;
import com.nexi.letmeeat.resoruces.PaymentRedirectResponse;
import com.nexi.letmeeat.resoruces.PostBookingRequest;
import com.nexi.letmeeat.services.PayPalService;
import com.nexi.letmeeat.utils.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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
    private EmailService emailService;

    @Autowired
    private PayPalService payPalService;


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

        PaymentRedirectResponse paymentRedirectResponse = payPalService.createOrder(amount, order.getUser().getUserId(), orderModel.getSeatId(), order.getOrderId(), request);

        return ResponseEntity.ok(paymentRedirectResponse);
    }

    @Override
    public ResponseEntity<Void> postBooking(PostBookingRequest postBookingRequest) {
        bookingRepository.save(Booking.builder()
                .table(tableRepository.findById(postBookingRequest.getTableId()).orElse(null))
                .user(userRepository.findById(postBookingRequest.getUserId()).orElse(null))
                .build());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Restaurant>> getRestaurant() {
        return new ResponseEntity<>(restaurantRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Menu> getRestaurantMenu(String restaurantId) {
        return ResponseEntity.ok(menuRepository.findMenuByRestaurantId(restaurantId));
    }

    @Override
    public ResponseEntity<List<Tables>> getRestaurantTables(String restaurantId)  {
        return ResponseEntity.ok(tableRepository.findTablesByRestaurantId(restaurantId));
    }

    @Override
    public ResponseEntity<List<User>> getUser()  {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> paymentSuccess(@RequestParam String orderId) {

        Order order = orderRepository.findById(Long.parseLong(orderId)).orElse(null);

        if(order != null) {
            emailService.sendEmail(order);
            HttpHeaders headers = new HttpHeaders();
            headers.set("Location", "https://letmeeat2.osc-fr1.scalingo.io/close");
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        }
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
