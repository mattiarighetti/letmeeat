package com.nexi.letmeeat.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seats")
@DynamicUpdate
@Data
public class Seat {
    @Id
    @Column(name = "seat_id")
    private Long seatId;

}
