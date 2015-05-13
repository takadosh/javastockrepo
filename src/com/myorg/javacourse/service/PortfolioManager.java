package com.myorg.javacourse.service;

import java.util.Calendar;
import java.util.Date;

import com.myorg.javacourse.Stock;
import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Portfolio.ALGO_RECOMMENDATION;

/**
 * This class returns the portfolio after adding stocks to it.
 * @author TalKadosh
 */

public class PortfolioManager {

	public Portfolio getPortfolio(){

			Portfolio myPortfolio = new Portfolio("Exercise 7 portfolio : ");
			myPortfolio.updateBalance(10000);
			
			Calendar cal1 = Calendar.getInstance();
			cal1.set(2014, 11, 15);
	 		Date date1 = cal1.getTime();
	 		Date date2 = cal1.getTime();
	 		Date date3 = cal1.getTime();

			Stock stock = new Stock("PIH" ,8.5f ,10.0f ,date1,ALGO_RECOMMENDATION.HOLD);
			myPortfolio.addStock(stock);
			myPortfolio.buyStock(stock, 20);
			
			Stock stock2 = new Stock("AAL", 25.5f, 30.0f,date2, ALGO_RECOMMENDATION.HOLD);
			myPortfolio.addStock(stock2);
			myPortfolio.buyStock(stock2, 30);
			
			Stock stock3 = new Stock("CAAS", 15.5f, 20.0f,date3, ALGO_RECOMMENDATION.HOLD); 
			myPortfolio.buyStock(stock3, 40);
			
			myPortfolio.sellStock("AAL", -1);
			myPortfolio.removeStock("CAAS");
			
		 return myPortfolio;
	}
	

}
