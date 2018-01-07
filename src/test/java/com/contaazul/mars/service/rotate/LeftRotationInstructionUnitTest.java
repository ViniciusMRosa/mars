package com.contaazul.mars.service.rotate;

import com.contaazul.mars.model.Robot;
import com.contaazul.mars.service.RobotInstruction;
import com.contaazul.mars.service.RobotInstructionTests;
import com.contaazul.mars.service.move.MoveInstruction;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LeftRotationInstructionUnitTest extends RobotInstructionTests{

    private RobotInstruction leftRotationInstruction;


    @Before
    public void initMRobotInstruction(){

        leftRotationInstruction =  new LeftRotationInstruction(super.movements);

    }

    @Test
    public void testMoveNorthRight(){

        Robot r = new Robot();
        r.setOrientation("N");

        r = leftRotationInstruction.executeMovement(r);

        verify(northOrientation,times(1)).rotate(r,"L");

    }

    @Test
    public void testMoveSouth(){

        Robot r = new Robot();
        r.setOrientation("S");

        r = leftRotationInstruction.executeMovement(r);
        verify(southOrientation,times(1)).rotate(r,"L");

    }

    @Test
    public void testMoveEast(){

        Robot r = new Robot();
        r.setOrientation("E");

        r = leftRotationInstruction.executeMovement(r);
        verify(eastOrientation,times(1)).rotate(r,"L");
    }

    @Test
    public void testMoveWest(){

        Robot r = new Robot();
        r.setOrientation("W");

        r = leftRotationInstruction.executeMovement(r);
        verify(westOrientation,times(1)).rotate(r,"L");

    }


}