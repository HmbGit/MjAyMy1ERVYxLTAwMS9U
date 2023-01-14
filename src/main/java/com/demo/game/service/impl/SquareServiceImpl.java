package com.demo.game.service.impl;

import com.demo.game.enums.XOValue;
import com.demo.game.model.Square;
import com.demo.game.repository.SquareRepository;
import com.demo.game.service.SquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SquareServiceImpl implements SquareService {

    @Autowired
    private SquareRepository squareRepository;

    /**
     *  Save Square
     * @param square
     * @return
     */
    @Override
    public Square saveSquare(Square square) {
        List<Square> squares = (List<Square>) squareRepository.findAll();
        if(squares.size() % 2 == 0)
            square.setXoValue(XOValue.X);
        else
            square.setXoValue(XOValue.O);

        return squareRepository.save(square);
    }
}
