package com.nexi.letmeeat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.nio.DoubleBuffer;

@Entity
@Table(name = "PAYMENTS")
@DynamicUpdate
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @Column(name = "PAYMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "SEAT_ID")
    private Seat seat;

    @Column(name = "TOTAL_AMOUNT")
    private Double total_amount;

    @Column
    private Long orderId;

    @Column
    private String status;

    private String receipt;

}
