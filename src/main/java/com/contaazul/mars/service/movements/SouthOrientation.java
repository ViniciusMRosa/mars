package com.contaazul.mars.service.movements;

import com.contaazul.mars.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SouthOrientation implements MoveStrattegy {
    private final static Logger LOGGER = LoggerFactory.getLogger(SouthOrientation.class);
    private Map<String,String> nextOrientation;

    public SouthOrientation() {
        this.nextOrientation =  new HashMap<>();
        this.nextOrientation.put("L","E");
        this.nextOrientation.put("R","W");
    }

    @Override
    public String getOrientation(String side) {
        return nextOrientation.get(side);
    }

    @Override
    public Robot move(Robot robot) {
        LOGGER.info("Moving robot to south");
        robot.moveDown();
        return robot;
    }
}
