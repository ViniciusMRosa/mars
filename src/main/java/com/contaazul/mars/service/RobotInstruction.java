package com.contaazul.mars.service;

import com.contaazul.mars.model.Robot;
import com.contaazul.mars.service.movements.MoveStrattegy;

import java.util.Map;

public abstract class RobotInstruction {

    protected Map<String,MoveStrattegy> movements;

    public RobotInstruction(Map<String, MoveStrattegy> movements) {
        this.movements = movements;
    }

    public abstract Robot executeMovement(final Robot robot);
}
