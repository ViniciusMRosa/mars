package com.contaazul.mars.controller;

import com.contaazul.mars.service.RobotControlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mars")
public class MarsController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MarsController.class);
    private RobotControlService robotControlService ;

    @Autowired
    public MarsController(RobotControlService robotControlService) {
        this.robotControlService = robotControlService;
    }

    @PostMapping("/{instruction}")
    public ResponseEntity<String> moveRobot(@PathVariable("instruction") final String instruction){
        LOGGER.info("Sending instruction {} to robot",instruction);
        String response = robotControlService.sendInstructionToRobotAndWaitPosition(instruction);
        return ResponseEntity.ok(response);
    }

}
