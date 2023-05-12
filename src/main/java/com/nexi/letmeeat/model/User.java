package com.nexi.letmeeat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@DynamicUpdate
@Data
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private Long userId;

    @Column
    @JsonProperty
    private String name;

    @Column
    @JsonProperty
    private String surname;

    @Column
    @JsonProperty
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Payment> payments;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;

}
