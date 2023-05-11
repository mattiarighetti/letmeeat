package com.nexi.letmeeat.rs;

import com.nexi.letmeeat.model.Tables;
import com.nexi.letmeeat.model.User;
import com.nexi.letmeeat.resoruces.PostBookingRequest;
import com.nexi.letmeeat.model.Menu;
import com.nexi.letmeeat.model.Restaurant;
import com.nexi.letmeeat.resoruces.OrderModel;
import com.nexi.letmeeat.resoruces.PaymentRedirectResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


public interface StdApi {

    @PostMapping(value = "/order", consumes = {"application/json"})
    ResponseEntity<PaymentRedirectResponse> postOrder(
            @RequestBody OrderModel order,
            HttpServletRequest request) throws IOException
            ;

    @PostMapping(value = "/booking", produces = {"application/json"})
    ResponseEntity<Void> postBooking(
            @RequestBody PostBookingRequest postBookingRequest)
          ;

    @GetMapping(value = "/restaurant", produces = {"application/json"})
    ResponseEntity<List<Restaurant>> getRestaurant()
          ;

    @GetMapping(value = "/restaurant/{restaurantId}/menu", produces = {"application/json"})
    ResponseEntity<Menu> getRestaurantMenu(@PathVariable("restaurantId") String restaurantId);

    @GetMapping(value = "/restaurant/{restaurantId}/tables", produces = {"application/json"})
    ResponseEntity<List<Tables>> getRestaurantTables(@PathVariable("restaurantId") String restaurantId);

    @GetMapping(value = "/users", produces = {"application/json"})
    ResponseEntity<List<User>> getUser();

    @GetMapping(value = "/payment/success", produces = {"application/json"})
    ResponseEntity<String> paymentSuccess(@RequestParam String orderId);

}
