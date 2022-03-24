package app.core.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import app.core.utils.JwtUtil;
import app.core.utils.JwtUtil.ClientDetails;

//@Component
public class LoginFilter implements Filter {

	private JwtUtil jwtUtil;

	public LoginFilter(JwtUtil jwtUtil) {
		super();
		this.jwtUtil = jwtUtil;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println(">>> ====== login filter before passing the request");
		// cast the request to HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		// get the token header
		String token = req.getHeader("token");
		System.out.println(token);
		try {
			ClientDetails clientDetails = jwtUtil.extractClient(token);
			chain.doFilter(request, response);
			System.out.println(">>> ====== login filter after passing the request to the end point");
		} catch (Exception e) {
			e.printStackTrace();
			// do not pass the request to the end point, but send an error response
			// cast the response to HttpServletResponse
			HttpServletResponse resp = (HttpServletResponse) response;
			// send an error to the client
			resp.sendError(HttpStatus.UNAUTHORIZED.value(), "you are not loggen in");
		}

	}

}
