package com.demo.game.test;

import com.demo.game.enums.XOValue;
import com.demo.game.model.Square;
import com.demo.game.repository.SquareRepository;
import com.demo.game.service.SquareService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SquareServiceTest {

    @Autowired
    private SquareService squareService;

    @MockBean
    private SquareRepository squareRepository;

    private Square square ;
    private List<Square> squares ;

    @BeforeEach
    void setUp(){
        square = Square.builder().id(1L).xoValue(XOValue.O).index(1).build();
        squares = new ArrayList<>();
    }

//    @Test
//    void shouldCreateFirstSquareWithX(){
//        Mockito.when(squareRepository.findAll()).thenReturn(squares);
//        Mockito.when(squareRepository.save(Mockito.any(Square.class))).thenReturn(square);
//
//        Boolean sqrt = squareService.saveSquare(square);
//        Assertions.assertEquals(false,sqrt);
//        Assertions.assertEquals("X",sqrt.getXoValue().name());
//    }
//
//    @Test
//    void shouldCreateSecondSquareWithO(){
//        squares.add(square);
//        square.setXoValue(XOValue.X);
//        Mockito.when(squareRepository.findAll()).thenReturn(squares);
//        Mockito.when(squareRepository.save(Mockito.any(Square.class))).thenReturn(square);
//
//        Square sqrt = squareService.saveSquare(square);
//        Assertions.assertNotNull(sqrt);
//        Assertions.assertEquals("O",sqrt.getXoValue().name());
//    }
//
//
//    @Test
//    void whenNineSquareFilledAndNoWinner(){
//        while (squares.size() <= 8){
//            squares.add(square);
//        }
//        Mockito.when(squareRepository.findAll()).thenReturn(squares);
//        Mockito.when(squareRepository.save(Mockito.any(Square.class))).thenReturn(square);
//        Square sqrt = squareService.saveSquare(square);
//        Assertions.assertNull(sqrt);
//    }
//
//    @Test
//    void whenNineSquareFilledAndNoWinner_shouldDeleteAllSquare(){
//        while (squares.size() <= 8){
//            squares.add(square);
//        }
//        Mockito.when(squareRepository.findAll()).thenReturn(squares);
//        Square sqrt = squareService.saveSquare(square);
//        Assertions.assertNull(sqrt);
//        verify(squareRepository).deleteAll();
//    }


    @Test
    void whenLinedThreeX_ShouldGetAWinner(){
        squares.add(Square.builder().xoValue(XOValue.X).index(0).build());
        squares.add(Square.builder().xoValue(XOValue.O).index(1).build());
        squares.add(Square.builder().xoValue(XOValue.X).index(4).build());
        squares.add(Square.builder().xoValue(XOValue.O).index(5).build());
        //the Square winner for index 8
        square.setXoValue(XOValue.X);
        square.setIndex(8);


        Mockito.when(squareRepository.findAll()).thenReturn(squares);
        Mockito.when(squareRepository.save(Mockito.any(Square.class))).thenReturn(square);
        String sqrt = squareService.saveSquare(square);

        Assertions.assertEquals(5,squares.size());
        Assertions.assertEquals("winner ==> X",sqrt);
    }
}
