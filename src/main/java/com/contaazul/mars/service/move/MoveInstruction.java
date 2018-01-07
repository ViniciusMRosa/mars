package com.contaazul.mars.service.move;

import com.contaazul.mars.model.Robot;
import com.contaazul.mars.service.RobotInstruction;
import com.contaazul.mars.service.movements.MoveStrattegy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("moveInstruction")
public class MoveInstruction extends RobotInstruction {

    @Autowired

    public MoveInstruction(@Qualifier("moveStrattegyMap") Map<String, MoveStrattegy> movements) {
        super(movements);
    }

    @Override
    public Robot executeMovement(Robot robot) {

        movements.get(robot.getOrientation()).move(robot);
        return robot;
    }
}
