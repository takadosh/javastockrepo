package com.myorg.javacourse.service;

import com.myorg.javacourse.Stock;
import com.myorg.javacourse.model.Portfolio;

public class PortfolioManager {

	public Portfolio getPortfolio(){
		Portfolio portfolio = new Portfolio();

		 Stock stock = new Stock("PIH",0, 13.1f, 12.4f, new java.util.Date(2014,11,15),0);
		 portfolio.addStock(stock);
		 stock = new Stock("AAL",0, 5.78f, 5.5f, new java.util.Date(2014,11,15),0);
		 portfolio.addStock(stock);
		 stock = new Stock("CAAS",0, 32.2f, 31.5f, new java.util.Date(2014,11,15),0);
		 portfolio.addStock(stock);
		 
		 return portfolio;
	}
	

}
