package com.nexi.letmeeat.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@DynamicUpdate
@Data
public class User {
    @Id
    @Column(name = "user_id")
    @JsonProperty
    private Long userId;

    @Column
    @JsonProperty
    private String name;

    @Column
    @JsonProperty
    private String surname;

    @Column
    @JsonProperty
    private String email;

}
