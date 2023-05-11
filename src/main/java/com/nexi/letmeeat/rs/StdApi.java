package com.nexi.letmeeat.rs;

import com.nexi.letmeeat.model.Menu;
import com.nexi.letmeeat.model.Order;
import com.nexi.letmeeat.model.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface StdApi {

    @GetMapping(value = "/order", produces = {"application/json"})
    ResponseEntity<Void> postOrder(
            @RequestBody Order order)
            throws Exception;

    @GetMapping(value = "/restaurant", produces = {"application/json"})
    ResponseEntity<List<Restaurant>> getRestaurant()
            throws Exception;

    @GetMapping(value = "/restaurant/{restaurantId}/menu", produces = {"application/json"})
    ResponseEntity<List<Menu>> getRestaurantMenu(@PathVariable("restaurantId") String restaurantId)
            throws Exception;


}
