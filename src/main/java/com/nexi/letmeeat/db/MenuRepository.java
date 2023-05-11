package com.nexi.letmeeat.db;

import com.nexi.letmeeat.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MenuRepository extends JpaRepository<Menu, Long>,
        JpaSpecificationExecutor<Menu> {

    Menu findMenuByRestaurantId(String restaurantId);
}