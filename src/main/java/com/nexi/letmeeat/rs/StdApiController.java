package com.nexi.letmeeat.rs;

import com.nexi.letmeeat.db.RestaurantRepository;
import com.nexi.letmeeat.model.Booking;
import com.nexi.letmeeat.model.Menu;
import com.nexi.letmeeat.model.Order;
import com.nexi.letmeeat.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StdApiController implements StdApi {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public StdApiController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public ResponseEntity<Void> postOrder(Order order) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Void> postBooking(Booking booking) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<Restaurant>> getRestaurant() throws Exception {
        return new ResponseEntity<>(restaurantRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Menu>> getRestaurantMenu(String restaurantId) throws Exception {
        return null;
    }
}
