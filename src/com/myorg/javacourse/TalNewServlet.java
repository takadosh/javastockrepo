package com.myorg.javacourse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TalNewServlet extends HttpServlet{
	
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
throws ServletException, IOException {
	
	//1 - Area of a circle
	
	int radius;
	double area;
	
	radius = 50;
	
	area = Math.PI * radius*radius;
	
	String resultStr1 = new String ("Area of circle with radius 50 is "+area+" square-cm");
	
	//2 - Length of a triangle's opposite
	int angleB;
	int hypotenuse;
	double opposite;
	
	angleB = 30;
	hypotenuse = 50;
	double conversion;
	conversion = angleB * Math.PI / 180;
	
	opposite = Math.sin(conversion) * hypotenuse;
	
	String resultStr2 = new String ("Length of opposite where angle B is 30 degrees and Hypotenuse length is 50 cm is: "+opposite+" cm");
	
	//3 - Power calculation
	double exp;
	double base;
	double result;
	
	base = 20.0;
	exp = 13.0;
	
	result = Math.pow(base, exp);
	
	String resultStr3 = new String("Power of 20 with exp of 13 is "+result+"");
	
	//print to screen
String resultStr = new String(resultStr1 + "<br>" + resultStr2 + "<br>" +resultStr3);
	
resp.setContentType("text/html");
resp.getWriter().println(resultStr);
 
}
}
