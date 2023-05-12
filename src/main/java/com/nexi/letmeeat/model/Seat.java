package com.nexi.letmeeat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "seats")
@DynamicUpdate
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_id")
    private Long seatId;

    @Column
    @JsonProperty
    private String number;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "TABLE_ID", nullable = false)
    private Tables tables;

}
