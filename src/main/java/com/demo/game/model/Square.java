package com.demo.game.model;

import com.demo.game.enums.XOValue;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class Square
 */
@Entity
@Table(name = "SQUARE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Square implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private XOValue xoValue;
    @Column(unique=true)
    private int index;
}
