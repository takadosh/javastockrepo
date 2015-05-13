package com.myorg.stock.servlet;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.service.PortfolioManager;

@SuppressWarnings({ "unused", "serial" })
public class PortfolioServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PortfolioManager portfolioManager = new PortfolioManager();
		Portfolio myPortfolio = portfolioManager.getPortfolio();
		resp.getWriter().println(myPortfolio.getHtmlString());

	}
		
}
