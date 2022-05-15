package app.core.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-b") // base uri [ip:port]
public interface ServiceBFeignClient {

	@GetMapping("/service/b") // route
	String callServiceB();

	@GetMapping("/service/b/greet") // route
	String callServiceBGreet();

}
