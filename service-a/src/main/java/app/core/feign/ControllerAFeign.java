package app.core.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ControllerAFeign {
	@Autowired
	private ServiceBFeighClient feignClient;
	
	@GetMapping("/feign")
	@HystrixCommand(fallbackMethod = "handleAFallback")
	public String handleA() {
		return "Feign call to service b" + feignClient.callSerivceB();
	}
	
	public String handleAFallback(Throwable t) {
		return "Feign Service a fallback massage: can't call service b, cause: " + t;
	}
}
