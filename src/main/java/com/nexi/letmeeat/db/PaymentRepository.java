package com.nexi.letmeeat.db;

import com.nexi.letmeeat.model.Menu;
import com.nexi.letmeeat.model.Payment;
import com.nexi.letmeeat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findPaymentsByUser(User user);
}
