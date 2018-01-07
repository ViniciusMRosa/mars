package com.contaazul.mars.service.move;

import com.contaazul.mars.model.Robot;
import com.contaazul.mars.service.RobotInstruction;
import com.contaazul.mars.service.RobotInstructionTests;
import com.contaazul.mars.service.movements.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MoveInstructionUnitTest extends RobotInstructionTests{


    private RobotInstruction moveInstruction ;


    @Before
    public void initMRobotInstruction(){

        moveInstruction =  new MoveInstruction(super.movements);

    }

    @Test
    public void testMoveNorth(){

        Robot r = new Robot();
        r.setOrientation("N");

        r = moveInstruction.executeMovement(r);

        verify(northOrientation,times(1)).move(r);

    }

    @Test
    public void testMoveSouth(){

        Robot r = new Robot();
        r.setY(2);
        r.setOrientation("S");

        r = moveInstruction.executeMovement(r);
        verify(southOrientation,times(1)).move(r);

    }

    @Test
    public void testMoveEast(){

        Robot r = new Robot();
        r.setOrientation("E");

        r = moveInstruction.executeMovement(r);
        verify(eastOrientation,times(1)).move(r);
    }

    @Test
    public void testMoveWest(){

        Robot r = new Robot();
        r.setX(2);
        r.setOrientation("W");

        r = moveInstruction.executeMovement(r);
        verify(westOrientation,times(1)).move(r);

    }


}