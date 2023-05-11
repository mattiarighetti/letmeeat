package com.nexi.letmeeat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menus")
@DynamicUpdate
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Menu {


    @Id
    @Column(name = "menu_id")
    @JsonProperty
    private Long menuId;

    @OneToMany(mappedBy="dishes")
    @JsonProperty
    private List<Dish> dish;

    @Column
    @JsonProperty
    private String name;

    @JsonProperty
    @Column(name = "restaurant_id")
    private String restaurantId;

}
