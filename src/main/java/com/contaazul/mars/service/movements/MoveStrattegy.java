package com.contaazul.mars.service.movements;

import com.contaazul.mars.model.Robot;

public interface MoveStrattegy {
    Robot move(Robot robot);
    String  getOrientation(final String side);


    default Robot rotate(Robot robot,String side){
            robot.setOrientation(getOrientation(side));
            return robot;
    }


}
