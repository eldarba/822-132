package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.core.utils.JwtUtil;
import app.core.utils.JwtUtil.ClientDetails;

@RestController
public class LoginController {

	@Autowired
	private JwtUtil jwtUtil;

	// edit the login method
	// the method should get email, password and client type.
	// the method should check that email and password are valid (admin@mail, 123)
	// if yes - create a token and return
	// if not - throw an exception - unauthorized - login failed

	// registration - we will give the client a token
	@PutMapping("/login")
	public String login(@RequestBody ClientDetails clientDetails) {
		return this.jwtUtil.generateToken(clientDetails);
	}

}
