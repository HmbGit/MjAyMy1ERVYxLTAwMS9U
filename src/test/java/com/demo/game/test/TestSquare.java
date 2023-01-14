package com.demo.game.test;

import com.demo.game.enums.XOValue;
import com.demo.game.model.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSquare {

    /**
     * test Square Class
     */
    @Test
    public void testSquareClass(){
        Square square = new Square(1L,XOValue.O,1);
        Assertions.assertEquals(1,square.getIndex());
    }

    /**
     *  test Square Class Should Fail with different Index
     */
    @Test
    public void testSquareClassShouldFail(){
        Square square = new Square(1L,XOValue.X,3);
        Assertions.assertNotEquals(1,square.getIndex());
    }

    /**
     *  test Square Class with X Enum Value
     */
    @Test
    public void testXOValue(){
        Square square = new Square(1L, XOValue.X,1);
        Assertions.assertEquals("X",square.getXoValue().name());
    }

}
