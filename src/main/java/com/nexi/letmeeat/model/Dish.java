package com.nexi.letmeeat.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String image;

    @Column
    @JsonProperty
    private String price;

}
