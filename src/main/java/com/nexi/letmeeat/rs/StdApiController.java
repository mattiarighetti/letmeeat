package com.nexi.letmeeat.rs;

import com.nexi.letmeeat.db.*;
import com.nexi.letmeeat.model.*;
import com.nexi.letmeeat.resoruces.OrderModel;
import com.nexi.letmeeat.resoruces.PaymentRedirectResponse;
import com.nexi.letmeeat.resoruces.PostBookingRequest;
import com.nexi.letmeeat.utils.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

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


    @Override
    public ResponseEntity<PaymentRedirectResponse> postOrder(OrderModel orderModel) {



        Optional<Seat> seat = seatRepository.findById(orderModel.getSeatId());
        List<Dish> dishes = dishRepository.findDishesByDishIdIn(orderModel.getDishIds());

        if (!seat.isPresent() || dishes.isEmpty())
            return ResponseEntity.badRequest().build();

        Order order = Order.builder().seat(seat.get()).dishes(dishes).
                status(Order.Status.PENDING.name()).build();

        orderRepository.save(order);

        PaymentRedirectResponse paymentRedirectResponse;
        try {
            paymentRedirectResponse = PaymentRedirectResponse.builder().
                    paymentUrl(buildPaymentUrl(order)).build();
        } catch (UnsupportedEncodingException e) {
            return ResponseEntity.internalServerError().build();
        }

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
        return ResponseEntity.ok(tableRepository.findTablesByRestaurantIdIs(restaurantId));
    }

    @Override
    public ResponseEntity<List<User>> getUser()  {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    private String buildPaymentUrl(Order order) throws UnsupportedEncodingException {
        return URLEncoder.encode("https://paypal:)", "UTF-8");
    }

    private void sendEmail(Order order) {

        String content = loadHtml();
        content = content.replace("[ORDER_N]", order.getOrderId().toString());
        content = content.replace("[TOTAL]", Double.toString(
                order.getDishes().stream().mapToDouble(Dish::getPrice).reduce(0, Double::sum)));
        StringBuilder bodyBuilder = new StringBuilder();
        order.getDishes().forEach(d ->
                bodyBuilder.append(String.format("<table border=0 cellpadding=0 cellspacing=0 width=100%><tr><td width=12 class=img style=font-size:0;line-height:0;text-align:left><td width=300 valign=top><div class=text style=color:#686868;font-family:Arial;font-size:14px;line-height:24px;text-align:left>%s</div><table border=0 cellpadding=0 cellspacing=0 width=100%><tr><td width=30 class=content-spacing style=font-size:0;line-height:0;text-align:left><td><div class=text2 style=color:#b0b0b0;font-family:Arial;font-size:14px;line-height:24px;text-align:left></div></table><td valign=top><div class=text-right style=color:#686868;font-family:Arial;font-size:14px;line-height:24px;text-align:right;white-space:nowrap>%.2f</div><div class=text-right2 style=color:#afafaf;font-family:Arial;font-size:14px;line-height:24px;text-align:right></div><td width=10 class=img style=font-size:0;line-height:0;text-align:left></table>", d.getName(), d.getPrice())));
        emailService.sendSimpleMessage(order.getUser().getEmail(), String.format("Receipt for order n %s", order.getOrderId()), bodyBuilder.toString());
    }

    private String loadHtml(){

        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get("mail.html"), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            //handle exception
        }

        return contentBuilder.toString();
    }


}
