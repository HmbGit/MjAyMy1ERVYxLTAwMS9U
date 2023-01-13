package com.demo.game.model;

import com.demo.game.enums.XOValue;
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
    private XOValue value;
    @Column(unique=true)
    private int index;
}
