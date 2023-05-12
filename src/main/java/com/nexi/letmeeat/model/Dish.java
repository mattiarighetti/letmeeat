package com.nexi.letmeeat.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dishes")
@DynamicUpdate
@Getter
@Setter
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dish_id")
    private Long dishId;

    @Column
    @JsonProperty
    private String name;

    @Column
    @JsonProperty
    private String description;

    @Column
    @JsonProperty
    private String imageUrl;

    @Column
    @JsonProperty
    private Double price;

    @ManyToOne
    @JoinColumn(name="menu_id", nullable=false)
    @JsonIgnore
    private Menu menu;

    @ManyToMany
    private List<Order> order;

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", menu=" + menu +
                ", order=" + order +
                '}';
    }
}
