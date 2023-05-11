package com.nexi.letmeeat.db;

import com.nexi.letmeeat.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
