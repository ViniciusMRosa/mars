package com.contaazul.mars.service;

import com.contaazul.mars.exceptions.InvalidInstructionException;
import com.contaazul.mars.exceptions.InvalidMoveException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotControlServiceIntegrationTest {

    @Autowired
    private RobotControlService robotControlService;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Test
    public void sendInstructionToRobotAndWaitPositionWithMoveAndRightRotation(){
        String finalPosition = robotControlService.sendInstructionToRobotAndWaitPosition("MMRMMRMM");
        assertEquals("(2, 0, S)",finalPosition);
    }


    @Test
    public void sendInstructionToRobotAndWaitPositionWithMoveAndLeftRotation(){
        String finalPosition = robotControlService.sendInstructionToRobotAndWaitPosition("MML");
        assertEquals("(0, 2, W)",finalPosition);
    }

    @Test
    public void sendInstructionToRobotRepeatedTimes(){
        String finalPosition = robotControlService.sendInstructionToRobotAndWaitPosition("MML");
        assertEquals("(0, 2, W)",finalPosition);

        finalPosition = robotControlService.sendInstructionToRobotAndWaitPosition("MML");
        assertEquals("(0, 2, W)",finalPosition);

        finalPosition = robotControlService.sendInstructionToRobotAndWaitPosition("MML");
        assertEquals("(0, 2, W)",finalPosition);
    }

    @Test
    public void testInvalidMovement_MustThrowException(){
        expectedException.expect(InvalidMoveException.class);
        expectedException.expect(hasProperty("message",is("Cannot move up")));
        String finalPosition = robotControlService.sendInstructionToRobotAndWaitPosition("MMMMMMMMMMMMMMMMMMMMMMMM");
    }


    @Test
    public void testInvalidInstruction_MustThrowException(){
        expectedException.expect(InvalidInstructionException.class);
        expectedException.expect(hasProperty("message",is("This robot cannot perform this action")));
        String finalPosition = robotControlService.sendInstructionToRobotAndWaitPosition("AAA");
    }

}
