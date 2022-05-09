package app.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@GetMapping("/fallback/serviceA")
	public String fallbackA() {
		return "Gateway Fallback: cannot reach service-a";
	}

	@GetMapping("/fallback/serviceB")
	public String fallbackB() {
		return "Gateway Fallback: cannot reach service-b";
	}

}
