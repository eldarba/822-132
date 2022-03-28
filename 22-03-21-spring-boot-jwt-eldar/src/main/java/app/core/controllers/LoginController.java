package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.utils.JwtUtil;
import app.core.utils.JwtUtil.ClientDetails;
import app.core.utils.JwtUtil.ClientDetails.ClientType;

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
	@PutMapping("/login/{email}/{password}")
	public String login(@PathVariable String email, @PathVariable String password, ClientType clientType) {
		switch (clientType) {
		case ADMIN:
			if (email.equals("admin@mail") && password.equals("123")) {
				ClientDetails clientDetails = new ClientDetails(0, email, clientType);
				return this.jwtUtil.generateToken(clientDetails);
			}
			break;
		case COMPANY:
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "login faild - company not supported");
		// get the company entity from the email.
		// if found - check the password.
		// if credentials good - return a token
		// break;
		case CUSTOMER:
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "login faild - customer not supported");
		// get the customer entity from the email.
		// if found - check the password.
		// if credentials good - return a token
		// break;
		}

		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "login faild - bad credentials");
	}

}
