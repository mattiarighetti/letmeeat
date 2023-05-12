package com.nexi.letmeeat.db;

import com.nexi.letmeeat.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {



}
