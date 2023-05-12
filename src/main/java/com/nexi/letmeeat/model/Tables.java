package com.nexi.letmeeat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "TABLES")
@DynamicUpdate
@Data
public class Tables {

    @Id
    @Column(name = "TABLE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tableId;

    @Column
    @JsonProperty
    private Integer size;

    @Column
    @JsonProperty
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    private Restaurant restaurant;

}
