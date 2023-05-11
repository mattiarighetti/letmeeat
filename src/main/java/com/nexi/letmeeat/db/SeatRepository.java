package com.nexi.letmeeat.db;

import com.nexi.letmeeat.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SeatRepository extends JpaRepository<Seat, Long>,
        JpaSpecificationExecutor<Seat> {

}