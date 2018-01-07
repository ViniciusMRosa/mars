package com.contaazul.mars.service;

import com.contaazul.mars.exceptions.InvalidInstructionException;
import com.contaazul.mars.model.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RobotControlService {

    private Map<String,RobotInstruction> instructions = new HashMap<>();
    private final static Logger LOGGER = LoggerFactory.getLogger(RobotControlService.class);


    @Autowired
    public RobotControlService(@Qualifier("moveInstruction") RobotInstruction moveInstruction,
                               @Qualifier("rightInstruction") RobotInstruction rightRotationInstruction,
                               @Qualifier("leftInstruction") RobotInstruction leftRotationInstruction) {


        this.instructions.put("M",moveInstruction);
        this.instructions.put("L",leftRotationInstruction);
        this.instructions.put("R",rightRotationInstruction);
    }

    public String sendInstructionToRobotAndWaitPosition(final String moveInstruction){

        String[] splittedInstruction = moveInstruction.toUpperCase().split("");
        LOGGER.info("Instruction splitted into {} diferent movements",splittedInstruction.length);
        Robot r = new Robot();
        for(String s : splittedInstruction){
            RobotInstruction robotInstruction = this.instructions.get(s);
            if(robotInstruction == null){
                LOGGER.error("Invalid instruction found {}. Throwing exception",s);
                throw new InvalidInstructionException("This robot cannot perform this action");
            }
            r = robotInstruction.executeMovement(r);
        }
        LOGGER.info("Returning final position {}",r.getFinalPositionFormatted());
        return r.getFinalPositionFormatted();
    }

}
