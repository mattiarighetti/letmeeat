package com.nexi.letmeeat.db;

import com.nexi.letmeeat.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long>,
        JpaSpecificationExecutor<Dish> {

    List<Dish> findDishesByDishIdIs(List<Long> ids);

}