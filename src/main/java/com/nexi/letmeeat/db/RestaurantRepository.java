package com.nexi.letmeeat.db;

import com.nexi.letmeeat.model.Restaurant;
import com.nexi.letmeeat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>,
        JpaSpecificationExecutor<User> {

}