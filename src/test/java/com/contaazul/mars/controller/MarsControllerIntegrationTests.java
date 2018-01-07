package com.contaazul.mars.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MarsControllerIntegrationTests {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testMoveRobot() throws Exception {

        this.mockMvc.perform(post("/mars/MMRMMRMM"))
                .andExpect(status().isOk())
                .andExpect(content().string("(2, 0, S)"));

    }


    @Test
    public void testMoveRobotInvalidMove() throws Exception {

        this.mockMvc.perform(post("/mars/MMMMMMMMMMM"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("400 Bad Request"));

    }

    @Test
    public void testMoveRobotEmptyInstructions() throws Exception {

        this.mockMvc.perform(post("/mars/ "))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("400 Bad Request"));

    }
    @Test
    public void testMoveRobotInvalidInstructions() throws Exception {

        this.mockMvc.perform(post("/mars/AAA"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("400 Bad Request"));

    }

}
