package com.demo.game.controller;

import com.demo.game.model.Square;
import com.demo.game.service.SquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/square")
public class SquareController {

    @Autowired
    private SquareService squareService;

    @PostMapping(value = "/create")
    public String createSquare(@RequestBody Square square){
        return  squareService.saveSquare(square);
    }
}
