package com.nexi.letmeeat.db;

import com.nexi.letmeeat.model.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TableRepository extends JpaRepository<Tables, Long>, JpaSpecificationExecutor<Tables> {

    List<Tables> findTablesByRestaurantIdIs(String restaurantId);

}
