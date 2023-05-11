package com.nexi.letmeeat.rs;

import com.nexi.letmeeat.db.*;
import com.nexi.letmeeat.model.*;
import com.nexi.letmeeat.resoruces.OrderModel;
import com.nexi.letmeeat.resoruces.PaymentRedirectResponse;
import com.nexi.letmeeat.resoruces.PostBookingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;

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


    @Override
    public ResponseEntity<PaymentRedirectResponse> postOrder(OrderModel orderModel) {

        Optional<Seat> seat = seatRepository.findById(orderModel.getSeatId());
        Optional<Dish> dish = dishRepository.findById(orderModel.getDishId());

        if (!seat.isPresent() || !dish.isPresent())
            return ResponseEntity.badRequest().build();

        Order order = Order.builder().seat(seat.get()).
                dish(dish.get()).status(Order.Status.PENDING.name()).build();

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
    public ResponseEntity<Void> postBooking(PostBookingRequest postBookingRequest)  {
        bookingRepository.save(Booking.builder()
                .table(tableRepository.findById(postBookingRequest.getTableId()).orElse(null))
                .user(userRepository.findById(postBookingRequest.getUserId()).orElse(null))
                .build());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Restaurant>> getRestaurant()  {
        return new ResponseEntity<>(restaurantRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Menu> getRestaurantMenu(String restaurantId)  {
        Menu menu = menuRepository.findMenuByRestaurantId(restaurantId);
        log.debug("Menu {}", menu);
        return ResponseEntity.ok(menuRepository.findMenuByRestaurantId(restaurantId));
    }

    private String buildPaymentUrl(Order order) throws UnsupportedEncodingException {
        return URLEncoder.encode("https://paypal:)", "UTF-8");
    }

}
