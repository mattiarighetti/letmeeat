package com.nexi.letmeeat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants")
@DynamicUpdate
@Data
public class Restaurant {

    @Id
    @Column(name = "restaurant_id")
    @JsonProperty
    private Long restaurantId;

    @Column
    @JsonProperty
    private String name;

    @Column
    @JsonProperty
    private String category;

}
