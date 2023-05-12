package com.nexi.letmeeat.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

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
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "SEAT_ID")
    @JsonIgnore
    private Seat seat;

    @Column(name = "TOTAL_AMOUNT")
    private Double total_amount;

    @Column(name = "timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date timestamp;

    @Column
    private Long orderId;

    @Column
    private String restaurantName;

    @Column
    private String status;

    private String receipt;

}
