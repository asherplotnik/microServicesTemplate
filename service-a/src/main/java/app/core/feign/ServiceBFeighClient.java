package app.core.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-b")
public interface ServiceBFeighClient {
	
	@GetMapping("/service/b")
	String callSerivceB();

}
