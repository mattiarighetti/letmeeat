package com.nexi.letmeeat.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "dishes")
@DynamicUpdate
@Data
public class Dish {

    @Id
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

}
