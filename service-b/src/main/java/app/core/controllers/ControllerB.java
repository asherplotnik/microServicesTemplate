package app.core.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerB {
	
	@Value("${spring.cloud.consul.discovery.instanceId}")
	String instanceId;
	
	@GetMapping("/service/b")
	public String handleA() {
		return "Hello from B. " + instanceId;
	}

}
