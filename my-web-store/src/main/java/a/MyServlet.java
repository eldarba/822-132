package a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	private int c;

	public MyServlet() {
		System.out.println("====================");
		System.out.println("====================");
		System.out.println("an instance of MyServlet was created by the container");
		System.out.println("====================");
		System.out.println("====================");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// write to the server console
		System.out.println("hello from servlet: " + ++c);
		// write to the client
		PrintWriter out = res.getWriter();
		out.println("hello from servlet: " + c);

		String name = req.getParameter("name");
		out.println("Hello " + name);

		double a = Double.parseDouble(req.getParameter("a"));
		double b = Double.parseDouble(req.getParameter("b"));
		double sum = a + b;
		out.println(a + " + " + b + " = " + sum);

	}
}
