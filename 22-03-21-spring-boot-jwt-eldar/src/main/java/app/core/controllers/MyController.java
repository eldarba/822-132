package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.utils.JwtUtil;
import app.core.utils.JwtUtil.ClientDetails;

@RestController
@RequestMapping("/api")
public class MyController {

	@Autowired
	private JwtUtil jwtUtil;

	// greet - we greet the client, knowing his details
	@GetMapping("/greet")
	public String greet(@RequestHeader String token) {
		try {
			ClientDetails client = this.jwtUtil.extractClient(token);
			return "Hello: " + client.getEmail();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "not logged in: " + e.getMessage());
		}
	}

	@GetMapping("/luck")
	public String luckyNumber(@RequestHeader String token) {
		return "your lucky number is: " + (int) (Math.random() * 101);
	}

}
