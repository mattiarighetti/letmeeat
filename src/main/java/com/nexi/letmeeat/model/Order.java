package com.nexi.letmeeat.model;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@DynamicUpdate
@Data
public class Order {

    @Id
    private Long id;

}
