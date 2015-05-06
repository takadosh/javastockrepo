package com.myorg.javacourse.model;

import com.myorg.javacourse.Stock;


/**
 * This class represents portfolio of stocks.
 * 
 * @author TalKadosh
 * 
 */


public class Portfolio {
	
	private String title = new String();
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	private int portfolioSize;
	
	public Portfolio(int portfolioSize, String title){
		this.portfolioSize = portfolioSize;
		this.title = title;
		
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
	
	}
	public Portfolio(Portfolio pf){
		this.portfolioSize = pf.getPortfolioSize();
		this.title = new String(pf.getTitle());
		
		for(int i = 0 ; i < pf.getPortfolioSize() ; i++)
		this.addStock(new Stock(pf.stocks[i]));
	}
	
	/**
	 * This method adds a new stock to the stocks array in the portfolio.
	 * 
	 * @param stock
	 */
	
	
	public void addStock(Stock stock){
		if(portfolioSize <= MAX_PORTFOLIO_SIZE-1 && stock != null)
		{
			stocks[portfolioSize] = stock;
			portfolioSize++;
		}
		}

	/**
	 * This method removes a specific stock by his symbol from the stocks array in the portfolio.
	 * 
	 * @param stock
	 */
	
	public void removeStock(Stock stock)
	{
		int j = 0;
		for(int i = 0 ; i < portfolioSize-1 ; i++){	
			if(this.stocks[i].getSymbol().equals(stock.getSymbol())){
				stocks[i] = null;
				j = i;
			}
		while (j != portfolioSize-1 && portfolioSize > 0){
		stocks[j] = stocks[j+1];
		j++;
		}
		portfolioSize--;
		}
	}
	public Stock getStock(Stock stock){
		return stock;
	}
	/**
	 * This method returns a string of the stocks content with HTML code.
	 * 
	 */
	
	public String getHtmlString(){
		String str = new String("<h1>" + title +"</h1>");
		for (int i = 0 ; i < portfolioSize ; i++)
		{
			str += stocks[i].getHtmlDescription() + "<br>";
		}
		return str;
	
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Stock[] getStocks() {
		return stocks;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}

	public int getPortfolioSize() {
		return portfolioSize;
	}

	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}

	
	}
		
	
