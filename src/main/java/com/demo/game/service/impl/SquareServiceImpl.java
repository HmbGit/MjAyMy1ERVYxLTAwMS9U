package com.demo.game.service.impl;

import com.demo.game.enums.XOValue;
import com.demo.game.model.Square;
import com.demo.game.repository.SquareRepository;
import com.demo.game.service.SquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SquareServiceImpl implements SquareService {

    @Autowired
    private SquareRepository squareRepository;

    /**
     * Save Square
     *
     * @param square
     * @return
     */
    @Override
    public String saveSquare(Square square) {
        List<Square> squares = (List<Square>) squareRepository.findAll();
        sizeOfListSquare(squares, square);
        String message = null;
        if (squares.size() <= 8) {
            square = squareRepository.save(square);
            squares.add(square);
            message = "square Created with "+ square.getXoValue().toString();
            if (squares.size() >= 5) {
                Map<Integer, String> boardGame = new HashMap<>();
                for (Square sqrt : squares) {
                    boardGame.put(sqrt.getIndex(), sqrt.getXoValue().toString());
                }
                String winner = checkWinner(boardGame);
                if(winner != null){
                    message = "winner ==> "+winner;
                }
            }

        } else {
            squareRepository.deleteAll();
            message = "no winner";
        }
        return message;
    }

    /**
     * size Of List Square
     *
     * @param squares
     * @param square
     * @return
     */
    private Square sizeOfListSquare(List<Square> squares, Square square) {
        if (squares.size() % 2 == 0) {
            square.setXoValue(XOValue.X);
        } else {
            square.setXoValue(XOValue.O);
        }
        return square;
    }


    public String checkWinner(Map<Integer, String> boardGame) {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = boardGame.get(0) + boardGame.get(1) + boardGame.get(2);
                    break;
                case 1:
                    line = boardGame.get(3) + boardGame.get(4) + boardGame.get(5);
                    break;
                case 2:
                    line = boardGame.get(6) + boardGame.get(7) + boardGame.get(8);
                    break;
                case 3:
                    line = boardGame.get(0) + boardGame.get(3) + boardGame.get(6);
                    break;
                case 4:
                    line = boardGame.get(1) + boardGame.get(4) + boardGame.get(7);
                    break;
                case 5:
                    line = boardGame.get(2) + boardGame.get(5) + boardGame.get(8);
                    break;
                case 6:
                    line = boardGame.get(0) + boardGame.get(4) + boardGame.get(8);
                    break;
                case 7:
                    line = boardGame.get(2) + boardGame.get(4) + boardGame.get(6);
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }

        return null;
    }
}

