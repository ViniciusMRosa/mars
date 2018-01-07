package com.contaazul.mars.service.movements;

import com.contaazul.mars.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EastOrientation implements MoveStrattegy {
    private final static Logger LOGGER = LoggerFactory.getLogger(EastOrientation.class);
    private Map<String,String> nextOrientation;

    public EastOrientation() {
        this.nextOrientation =  new HashMap<>();
        this.nextOrientation.put("L","N");
        this.nextOrientation.put("R","S");
    }

    @Override
    public Robot move(Robot robot) {
        LOGGER.info("Moving robot to east");
        robot.moveRigth();
        return robot;
    }

    @Override
    public String getOrientation(String side) {
        return nextOrientation.get(side);
    }
}
