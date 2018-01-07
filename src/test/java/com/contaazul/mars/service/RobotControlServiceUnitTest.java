package com.contaazul.mars.service;

import com.contaazul.mars.exceptions.InvalidInstructionException;
import com.contaazul.mars.model.Robot;
import com.contaazul.mars.service.move.MoveInstruction;
import com.contaazul.mars.service.rotate.LeftRotationInstruction;
import com.contaazul.mars.service.rotate.RightRotationInstruction;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RobotControlServiceUnitTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private MoveInstruction moveInstruction ;

    @Mock
    private LeftRotationInstruction leftRotationInstruction;

    @Mock
    private RightRotationInstruction rightRotationInstruction;


    private RobotControlService robotControlService ;

    @Before
    public void initRobotControlService(){
        robotControlService =  new RobotControlService(moveInstruction,rightRotationInstruction,leftRotationInstruction);
    }
    @Test
    public void sendInstructionToRobotAndWaitPosition() {
        Robot r = new Robot();
        // (2, 0, S)
        when(moveInstruction.executeMovement(any(Robot.class))).thenReturn(getRobotInDiferentPosition(r,2,0,"S"));
        when(leftRotationInstruction.executeMovement(any(Robot.class))).thenReturn(getRobotInDiferentPosition(r,2,0,"S"));
        when(rightRotationInstruction.executeMovement(any(Robot.class))).thenReturn(getRobotInDiferentPosition(r,2,0,"S"));
        String finalPosition = robotControlService.sendInstructionToRobotAndWaitPosition("MMRMMRMM");

        assertEquals("(2, 0, S)",finalPosition);
        verify(moveInstruction,times(6)).executeMovement(any(Robot.class));
        verify(rightRotationInstruction,times(2)).executeMovement(any(Robot.class));
        verifyZeroInteractions(leftRotationInstruction);

    }


    @Test
    public void sendInvalidInstruction() {
        Robot r = new Robot();
        when(moveInstruction.executeMovement(any(Robot.class))).thenReturn(getRobotInDiferentPosition(r,2,0,"S"));

        expectedException.expect(InvalidInstructionException.class);
        expectedException.expect(hasProperty("message",is("This robot cannot perform this action")));

        String finalPosition = robotControlService.sendInstructionToRobotAndWaitPosition("MEM");

        verify(moveInstruction,times(1)).executeMovement(any(Robot.class));

    }

    private Robot getRobotInDiferentPosition(Robot robot, int x, int y, String orientation) {
        robot.setX(x);
        robot.setY(y);
        robot.setOrientation(orientation);
        return robot;
    }
}