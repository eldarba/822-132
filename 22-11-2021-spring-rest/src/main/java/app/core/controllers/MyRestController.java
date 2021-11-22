package app.core.controllers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyRestController {

	// http://localhost:8080/api/hello
	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public String helloWorld() {
		return "Hello World!";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/rand")
	public int random() {
		int r = (int) (Math.random() * 101);
		System.out.println("rand: " + r);
		return r;
	}

	@GetMapping("/date")
	public LocalDateTime getDate() {
		LocalDateTime date = LocalDateTime.now();
		System.out.println(date);
		return date;
	}

}
