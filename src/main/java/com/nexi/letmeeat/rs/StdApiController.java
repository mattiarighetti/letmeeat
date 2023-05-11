package com.nexi.letmeeat.rs;

import com.nexi.letmeeat.model.Menu;
import com.nexi.letmeeat.model.Order;
import com.nexi.letmeeat.model.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StdApiController implements StdApi {


    @Override
    public ResponseEntity<Void> postOrder(Order order) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Restaurant>> getRestaurant() throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Menu>> getRestaurantMenu(String restaurantId) throws Exception {
        return null;
    }
}
