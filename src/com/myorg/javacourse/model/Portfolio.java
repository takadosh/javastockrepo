package com.myorg.javacourse.model;

import com.myorg.javacourse.Stock;

/**
 * This class represents portfolio of stocks.
 * 
 * @author TalKadosh
 * 
 */
public class Portfolio {
	public enum ALGO_RECOMMENDATION{
		BUY,SELL,REMOVE,HOLD;
	}
	
	private String title = new String();
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	private int portfolioSize = 0;
	private float balance;
	
	public Portfolio(String title){
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
	public void addStock(Stock stock)
	{
		
		if(this.getPortfolioSize() == (MAX_PORTFOLIO_SIZE-1))
		{
			System.out.println("Cant add a new stock, portfolio can have only " + MAX_PORTFOLIO_SIZE + " stocks");
		}
		else
		{
			for(int i = 0 ; i < portfolioSize ; i++)
			{
				if(stock.getSymbol().equals(stocks[i].getSymbol()))
				{
					System.out.println("This stock already exists");
					return;
				}
			}
				
		}
		
		if(stock != null)
		{
		stocks[portfolioSize] = stock;
		stocks[portfolioSize].setStockQuantity(0);
		portfolioSize++;
		}
		}

	/**
	 * This method removes a specific stock by his symbol from the stocks array in the portfolio and sells it.
	 * 
	 * @param symbol
	 */
	public boolean removeStock(String symbol)
	{
		boolean flag = false;
		int j = 0;
		for(int i = 0 ; i < portfolioSize ; i++)
		{	
			if(symbol.equals(this.stocks[i].getSymbol()))
			{
				this.sellStock(symbol, this.stocks[i].getStockQuantity());
				stocks[i] = null;
				j = i;
				flag = true;
				break;
			}
		}
		if(flag == false)
			return flag;
		
		while (j <= portfolioSize && portfolioSize > 0)
		{
		stocks[j] = stocks[j+1];
		j++;
		}
		portfolioSize--;
		return flag;
	}
	/**
	 * This method buys a specific stock and if it doesnt exist adds it to the portfolio.
	 * 
	 * @param stock
	 * @param quantity
	 */
	public boolean buyStock(Stock stock, int quantity)
	{
		boolean isOk = false;
		boolean flag = false;
		for(int i = 0 ; i < portfolioSize ; i++)
		{
			if (stock.getSymbol().equals(stocks[i].getSymbol()))
			{
				flag = true;
			}
		}
		if(flag == false)
			this.addStock(stock);
		for(int i = 0 ; i < portfolioSize ; i++)
		{
			if(quantity == -1)
			{
				
				if(stock.getSymbol().equals(stocks[i].getSymbol()))
				{
				int j = (int)(balance / stocks[i].getAsk());
				this.balance -= stocks[i].getAsk()*j;
				stocks[i].setStockQuantity(stocks[i].getStockQuantity()+j);
				isOk = true;
				}
			}
		
			else
			{
				if(stock.getSymbol().equals(stocks[i].getSymbol()))
				{
					if(quantity * stock.getAsk() > this.balance)
					{
						System.out.println("Not enough balance to complete purchase");
					}
		
					else
					{
						this.balance -= quantity * stock.getAsk();
						stocks[i].setStockQuantity(stocks[i].getStockQuantity()+quantity);
						isOk = true;
					}
				}
			}	
	}
		return isOk;
	}
	/**
	 * This method sells a specific stock by his symbol according to the given quantity.
	 * 
	 * @param symbol
	 * @param quantity
	 */
	public boolean sellStock(String symbol, int quantity)
	{
		boolean flag = false;
		int j = 0;
		for(int i = 0 ; i < portfolioSize ; i++)
		{
			if(this.stocks[i].getSymbol().equals(symbol))
			{
				j = i;
				break;
			}
		}
		if(quantity != -1)
		{
			if(quantity <= this.stocks[j].getStockQuantity() )
			{
			this.balance += this.stocks[j].getBid() * quantity;
			this.stocks[j].setStockQuantity(this.stocks[j].getStockQuantity()-quantity);
			flag = true;
			}
			else
				System.out.println("not enough stocks to sell");
		}
		else
		{
			this.balance += this.stocks[j].getBid() * this.stocks[j].getStockQuantity();
			this.stocks[j].setStockQuantity(0);
			flag = true;
		}
		return flag;
	}
	/**
	 * This method returns the total value of portfolio's stocks.
	 * 
	 */
	public float getStocksValue()
	{
		float totalStockValue = 0; 
		for(int i = 0 ; i < getPortfolioSize() ; i++)
		{
			totalStockValue += this.stocks[i].getBid() * this.stocks[i].getStockQuantity();
		}
		return totalStockValue;
	}
	/**
	 * This method returns the total value of portfolio's stocks with the balance's value.
	 * 
	 */
	public float returnTotalValue()
	{
		float totalValue = 0;
		totalValue = this.getStocksValue() + this.getBalance();
		return totalValue;
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
		str += "Total stocks value : " + this.getStocksValue() + "$" + "<br>";
		str += "Total portfolio value : " + this.returnTotalValue() + "$" + "<br>";
		str += "Balance : " + this.balance + "$" + "<br>";
		return str;
	}
	/**
	 * This method updates the balance by adding amount to the current balance.
	 * @param amount
	 */
	public void updateBalance(float amount){
		if(amount < 0 && this.balance + amount < 0){
			System.out.println("this amount is illegal");
		}
		if(this.balance + amount >= 0){
			this.balance += amount;
		}
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
	
	public float getBalance(){
		return balance;
	}
}
		
	
