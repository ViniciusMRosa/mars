package com.contaazul.mars;

import com.contaazul.mars.service.RobotInstruction;
import com.contaazul.mars.service.movements.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsApplication.class, args);
	}

	@Bean("moveStrattegyMap")
	public Map<String,MoveStrattegy> moveStrattegyMap(){

			Map<String,MoveStrattegy> movements  = new HashMap<>();
			movements.put("N",new NorthOrientation());
			movements.put("S",new SouthOrientation());
			movements.put("W",new WestOrientation());
			movements.put("E",new EastOrientation());

			return movements;
	}
}
