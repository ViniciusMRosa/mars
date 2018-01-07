package com.contaazul.mars.controller;

import com.contaazul.mars.service.RobotControlService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MarsControllerUnitTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private RobotControlService robotControlService;

    @InjectMocks
    private MarsController marsController ;

    @Test
    public void testMoveRobot(){

        when(robotControlService.sendInstructionToRobotAndWaitPosition("MMRMMRMM"))
                .thenReturn("(2, 0, S)");

        ResponseEntity<?> responseEntity = marsController.moveRobot("MMRMMRMM");
        assertNotNull(responseEntity);
        assertEquals(200,responseEntity.getStatusCodeValue());
        assertEquals("(2, 0, S)",responseEntity.getBody());
        verify(robotControlService,times(1)).sendInstructionToRobotAndWaitPosition("MMRMMRMM");
    }

    @Test
    public void testMoveRobotRepeatedInstructions(){

        when(robotControlService.sendInstructionToRobotAndWaitPosition("MMRMMRMM"))
                .thenReturn("(2, 0, S)");

        ResponseEntity<?> responseEntity = marsController.moveRobot("MMRMMRMM");
        assertNotNull(responseEntity);
        assertEquals(200,responseEntity.getStatusCodeValue());
        assertEquals("(2, 0, S)",responseEntity.getBody());



        responseEntity = marsController.moveRobot("MMRMMRMM");
        assertNotNull(responseEntity);
        assertEquals(200,responseEntity.getStatusCodeValue());
        assertEquals("(2, 0, S)",responseEntity.getBody());

        verify(robotControlService,times(2)).sendInstructionToRobotAndWaitPosition("MMRMMRMM");


    }

}
