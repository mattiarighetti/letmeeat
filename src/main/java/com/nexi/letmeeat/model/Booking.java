package com.nexi.letmeeat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKINGS")
@DynamicUpdate
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
