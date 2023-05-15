package com.nexi.letmeeat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menus")
@DynamicUpdate
@Getter
@Setter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    @JsonProperty
    private Long menuId;

    @OneToMany(mappedBy="menu")
    @JsonProperty
    private List<Dish> dishes;

    @Column
    @JsonProperty
    private String name;

    @JsonProperty
    @Column(name = "restaurant_id")
    private String restaurantId;

}
