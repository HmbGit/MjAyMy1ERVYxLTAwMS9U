package com.demo.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class Square
 */
@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Square implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String  value;
    @Column(unique=true)
    private int index;
}
