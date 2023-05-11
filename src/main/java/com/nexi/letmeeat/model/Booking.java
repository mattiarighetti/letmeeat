package com.nexi.letmeeat.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKINGS")
@DynamicUpdate
@Data
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "TABLE_ID", nullable = false)
    private Tables table;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

}
