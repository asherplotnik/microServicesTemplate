package app.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbacksController {
	
	@GetMapping("/serviceA")
	public String fallbackA(Throwable t) {
		return "Gateway fallback message: can't call service A.cause: " + t;
	}
	
	@GetMapping("/serviceB")
	public String fallbackB(Throwable t) {
		return "Gateway fallback message: can't call service B.cause: " + t;
	}

}
