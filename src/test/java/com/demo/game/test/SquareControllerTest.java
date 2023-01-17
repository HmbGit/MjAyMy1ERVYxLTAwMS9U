package com.demo.game.test;

import com.demo.game.controller.SquareController;
import com.demo.game.enums.XOValue;
import com.demo.game.model.Square;
import com.demo.game.service.SquareService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = {SquareController.class})
@ContextConfiguration(classes = {
        SquareController.class,
        Square.class,
        SquareService.class })
public class SquareControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SquareService squareService;


    private static final String SQUARE = "/square/create";


    @Test
    void addSquareTest() throws Exception {
        String requestBody = "{\n" +
                "    \"xoValue\":\"X\",\n" +
                "    \"index\":\"0\"\n" +
                "}";
        Mockito.when(squareService.saveSquare(Mockito.any(Square.class))).thenReturn("square Created with X");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(SQUARE).content(requestBody)
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON);

        String result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                 .andReturn()
                 .getResponse().getContentAsString();

        Assertions.assertEquals("square Created with X",result);
    }
}
