package com.contaazul.mars.service;

import com.contaazul.mars.service.movements.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public abstract class RobotInstructionTests {


    @Mock
    protected EastOrientation eastOrientation;
    @Mock
    protected WestOrientation westOrientation;
    @Mock
    protected NorthOrientation northOrientation;
    @Mock
    protected SouthOrientation southOrientation;

    protected Map<String,MoveStrattegy> movements  = new HashMap<>();


    @Before
    public void initMocks() {

        movements.put("N", northOrientation);
        movements.put("S", southOrientation);
        movements.put("W", westOrientation);
        movements.put("E", eastOrientation);
    }


}
