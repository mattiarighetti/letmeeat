package com.nexi.letmeeat.db;

import com.nexi.letmeeat.model.Booking;
import com.nexi.letmeeat.model.Payment;
import com.nexi.letmeeat.model.Tables;
import com.nexi.letmeeat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingByUser(User user);

    List<Booking> findBookingByUserAndTable(User user, Tables table);

}
