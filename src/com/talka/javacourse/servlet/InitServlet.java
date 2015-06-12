package com.talka.javacourse.servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import org.algo.service.ServiceManager;

import com.talka.javacourse.service.PortfolioManager;
@SuppressWarnings("serial")
public class InitServlet extends javax.servlet.http.HttpServlet {

	public void init() throws ServletException {
		PortfolioManager pm = new PortfolioManager();
		ServiceManager.setPortfolioManager(pm);
	}
}
