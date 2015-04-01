package com.myorg.javacourse;
import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class TalServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int num1;
		int num2;
		int num3;
		
		num1 = 4;
		num2 = 3;
		num3 = 7;
		
		int result = (num1+num2)*num3;
		String resultStr = new String ("Result of ("+num1+"+"+num2+")*"+num3+"="+result+"");
		resp.setContentType("text/plain");
		resp.getWriter().println(resultStr);
	}
}
