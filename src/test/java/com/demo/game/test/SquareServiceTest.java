package com.demo.game.test;

import com.demo.game.enums.XOValue;
import com.demo.game.model.Square;
import com.demo.game.repository.SquareRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SquareServiceTest {

    @MockBean
    private SquareRepository squareRepository;

    private Square square ;
    private List<Square> squares ;

    @BeforeEach
    void setUp(){
        square = Square.builder().id(1L).xoValue(XOValue.X).index(1).build();
        squares = new ArrayList<>();
    }

    @Test
    void shouldCreateFirstSquareWithX(){
        Mockito.when(squareRepository.findAll()).thenReturn(squares);
        Mockito.when(squareRepository.save(Mockito.any(Square.class))).thenReturn(square);

        Square sqrt = squareRepository.save(square);
        Assertions.assertNotNull(sqrt);
        Assertions.assertEquals("X",sqrt.getXoValue().name());
    }
}
