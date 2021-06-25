package app.core.controllers;

//import java.net.URI;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ControllerA {

	@Autowired
	private RestTemplate template;
	//@Autowired
	//private DiscoveryClient discoveryClient;
	//@Autowired
	//private LoadBalancerClient lb;
	
	@GetMapping("/service/a")
	@HystrixCommand(fallbackMethod = "handleAFallback")
	public String handleA() {
		String url = "http://service-b/service/b";
		return "srevice a calling b: " + template.getForObject(url, String.class);
	}
	
	public String handleAFallback(Throwable t) {
		return "Service a fallbak massage: can't call service b, cause: " + t;
	}

//	@GetMapping("/service/a")
//	public String handleA() {
//		try {
//			String serviceId = "service-b";
//			URI baseUri = getServiceInstanceBaseUriLB(serviceId);
//			String url = baseUri + "/service/b";
//			System.out.println(url);
//			return "srevice a calling b: " + template.getForObject(url, String.class);
//		} catch (Exception e) {
//			e.printStackTrace(System.out);
//			return "Error";
//		}
//	}
//
////	private URI getServiceInstanceBaseUri(String serviceId) {
////		System.out.println("service id: " + serviceId);
////		List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceId);
////		for (ServiceInstance serviceInstance : serviceInstances) {
////			System.out.println(serviceInstance);
////		}
////		return serviceInstances.get(0).getUri();
////	}
//	private URI getServiceInstanceBaseUriLB(String serviceId) {
//		return lb.choose(serviceId).getUri();
//	}
}
