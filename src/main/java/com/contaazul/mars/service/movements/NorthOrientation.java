package com.contaazul.mars.service.movements;

import com.contaazul.mars.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NorthOrientation implements MoveStrattegy {
    private final static Logger LOGGER = LoggerFactory.getLogger(NorthOrientation.class);
    private Map<String,String> nextOrientation;

    public NorthOrientation() {
        this.nextOrientation =  new HashMap<>();
        this.nextOrientation.put("L","W");
        this.nextOrientation.put("R","E");
    }
    @Override
    public Robot move(Robot robot) {
        LOGGER.info("Moving robot to north");
        robot.moveUp();
        return robot ;

    }

    @Override
    public String getOrientation(String side) {
        return nextOrientation.get(side);

    }
}
