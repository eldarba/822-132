package app.core.beans.login;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginManager {

	private boolean loggedIn;
	@Value("${system.password}")
	private String password;

	public boolean login(String password) {
		System.out.println("attempting login");
		if (password.equals(this.password)) {
			this.loggedIn = true;
			return true;
		} else {
			return false;
		}
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

}
