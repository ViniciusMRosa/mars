package com.contaazul.mars.service.rotate;

import com.contaazul.mars.model.Robot;
import com.contaazul.mars.service.RobotInstruction;
import com.contaazul.mars.service.RobotInstructionTests;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RightRotationInstructionUnitTest extends RobotInstructionTests{

    private RobotInstruction rightRotationInstruction;


    @Before
    public void initMRobotInstruction(){

        rightRotationInstruction =  new RightRotationInstruction(super.movements);

    }

    @Test
    public void testMoveNorthRight(){

        Robot r = new Robot();
        r.setOrientation("N");

        r = rightRotationInstruction.executeMovement(r);

        verify(northOrientation,times(1)).rotate(r,"R");

    }

    @Test
    public void testMoveSouth(){

        Robot r = new Robot();
        r.setOrientation("S");

        r = rightRotationInstruction.executeMovement(r);
        verify(southOrientation,times(1)).rotate(r,"R");

    }

    @Test
    public void testMoveEast(){

        Robot r = new Robot();
        r.setOrientation("E");

        r = rightRotationInstruction.executeMovement(r);
        verify(eastOrientation,times(1)).rotate(r,"R");
    }

    @Test
    public void testMoveWest(){

        Robot r = new Robot();
        r.setOrientation("W");

        r = rightRotationInstruction.executeMovement(r);
        verify(westOrientation,times(1)).rotate(r,"R");

    }
}