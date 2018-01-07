package com.contaazul.mars.service.movements;

import com.contaazul.mars.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WestOrientation implements MoveStrattegy {
    private final static Logger LOGGER = LoggerFactory.getLogger(WestOrientation.class);
    private Map<String,String> nextOrientation;

    public WestOrientation() {
        this.nextOrientation =  new HashMap<>();
        this.nextOrientation.put("L","S");
        this.nextOrientation.put("R","N");
    }
    @Override
    public Robot move(Robot robot) {
        LOGGER.info("Moving robot to west");
        robot.moveLeft();
        return robot;
    }

    @Override
    public String getOrientation(String side) {
        return nextOrientation.get(side);
    }
}
