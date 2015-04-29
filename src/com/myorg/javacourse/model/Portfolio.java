package com.myorg.javacourse.model;

import com.myorg.javacourse.Stock;

public class Portfolio {
	
	private String title = new String("MyPortfolio :");
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	private int portfolioSize = 0;
	public void addStock(Stock stock){
		if(portfolioSize <= MAX_PORTFOLIO_SIZE-1 && stock != null)
		{
			stocks[portfolioSize] = stock;
			portfolioSize++;
		}
		}
	public Stock getStock(Stock stock){
		return stock;
	}
	
	public String getHtmlString(){
		String str = new String("<h1>" + title +"</h1>");
		for (int i = 0 ; i < portfolioSize ; i++)
		{
			str += stocks[i].getHtmlDescription() + "<br>";
		}
		return str;
	
	}

	
	}
		
	
