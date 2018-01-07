package com.contaazul.mars.service.rotate;

import com.contaazul.mars.model.Robot;
import com.contaazul.mars.service.RobotInstruction;
import com.contaazul.mars.service.movements.MoveStrattegy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component("rightInstruction")
public class RightRotationInstruction extends RobotInstruction {
    private final static Logger LOGGER = LoggerFactory.getLogger(RightRotationInstruction.class);
    @Autowired
    public RightRotationInstruction(@Qualifier("moveStrattegyMap") Map<String, MoveStrattegy> movements) {
        super(movements);
    }

    @Override
    public Robot executeMovement(Robot robot) {
        MoveStrattegy moveStrattegy = movements.get(robot.getOrientation());
        LOGGER.info("Rotating robot to right. New orientation {}",moveStrattegy.getOrientation("R"));
        moveStrattegy.rotate(robot,"R");
        return robot;
    }
}
