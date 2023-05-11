package com.nexi.letmeeat.model;

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
    private Long menuId;

    @OneToMany(mappedBy="dishes")
    private List<Dish> dish;

    @Column
    private String name;

    @Column(name = "restaurant_id")
    private String restaurantId;

}
