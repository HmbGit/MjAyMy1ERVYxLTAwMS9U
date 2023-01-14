package com.demo.game.test;

import com.demo.game.enums.XOValue;
import com.demo.game.model.Square;
import com.demo.game.repository.SquareRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * test the Square Repository
 */
@SpringBootTest
public class SquareRepositoryTest {

    @Autowired
    SquareRepository squareRepository;

    /**
     * Initialise Square Object
     * @throws Exception
     */
    @BeforeEach
    public void beforeEach() throws Exception {
        squareRepository.save(new Square(1L,XOValue.X,2));
        squareRepository.save(new Square(2L,XOValue.O,1));
    }

    /**
     *  find all Square and return the two square created before
     */
    @Test
    void mustReturnTwoSquare(){
        List<Square> square = (List<Square>) squareRepository.findAll();
        Assertions.assertEquals(2,square.size());
    }

    /**
     * find the second square created and verifier his index
     */
    @Test
    void mustGetIndexForTheSecondSquare(){
        Square square = squareRepository.findById(2L).get();
        Assertions.assertEquals(1,square.getIndex());
    }
}
