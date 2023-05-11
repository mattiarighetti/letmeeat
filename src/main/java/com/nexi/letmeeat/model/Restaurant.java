package com.nexi.letmeeat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RESTAURANTS")
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


    @Column
    @JsonProperty
    private String imageUrl;


}
