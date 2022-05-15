package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ControllerAFeign {

	@Autowired
	private ServiceBFeignClient feignClient;

	@HystrixCommand(fallbackMethod = "fallbackForhandleA")
	@GetMapping("/service/a/feign")
	public String handleA() {
//		String url = "http://service-b/service/b";
		String resFromB = this.feignClient.callServiceB();
		return "Service A FEIGN CLIENT calls: " + resFromB;
	}

	@HystrixCommand(fallbackMethod = "fallbackForhandleA")
	@GetMapping("/service/a/feign/greet")
	public String greet() {
		String resFromB = this.feignClient.callServiceBGreet();
		return "Service A FEIGN CLIENT calls: " + resFromB;
	}

	public String fallbackForhandleA(Throwable t) {
		return "service-a fallback: " + t;
	}

}
