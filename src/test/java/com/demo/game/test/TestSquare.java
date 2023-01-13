package com.demo.game.test;

import com.demo.game.model.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSquare {

    @Test
    public void testSquareClass(){
        Square square = new Square(1L,"X",1);
        Assertions.assertEquals(1,square.getIndex());
    }

    /**
     *  test Square Class Should Fail with different Index
     */
    @Test
    public void testSquareClassShouldFail(){
        Square square = new Square(1L,"X",3);
        Assertions.assertNotEquals(1,square.getIndex());
    }
}
