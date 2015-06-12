package com.talka.javacourse.model;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;

import com.talka.javacourse.Stock;
import com.talka.javacourse.exception.BalanceException;
import com.talka.javacourse.exception.PortfolioFullException;
import com.talka.javacourse.exception.StockNotExistException;

/**
 * This class represents portfolio of stocks.
 * 
 * @author TalKadosh
 * 
 */
public class Portfolio implements PortfolioInterface{
	public enum ALGO_RECOMMENDATION{
		BUY,SELL,REMOVE,HOLD;
	}
	
	private String title = new String();
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	private int portfolioSize = 0;
	private float balance;
	
	public Portfolio(){
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
	
	}
	public Portfolio(Portfolio pf) throws PortfolioFullException{
		this.portfolioSize = pf.getPortfolioSize();
		this.title = new String(pf.getTitle());
		
		for(int i = 0 ; i < pf.getPortfolioSize() ; i++)
		this.addStock(new Stock(pf.stocks[i]));
	}
	public Portfolio(Stock[] stock){
		this.title = new String();
		this.portfolioSize = stock.length;
		this.balance = getBalance();
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		
		for(int i = 0 ; i < this.getPortfolioSize() ; i++)
			this.stocks[i] = new Stock (stock[i]);
	}
	
	/**
	 * This method adds a new stock to the stocks array in the portfolio.
	 * 
	 * @param stock
	 */

	public void addStock(Stock stock) throws PortfolioFullException{
		
		if(this.getPortfolioSize() == (MAX_PORTFOLIO_SIZE))
		{
			throw new PortfolioFullException();
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
	public void removeStock(String symbol)throws StockNotExistException{
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
			throw new StockNotExistException();
		
		while (j < portfolioSize && portfolioSize > 0 && j != MAX_PORTFOLIO_SIZE-1)
		{
		stocks[j] = stocks[j+1];
		j++;
		}
		portfolioSize--;
	}
	/**
	 * This method buys a specific stock and if it doesnt exist adds it to the portfolio.
	 * 
	 * @param stock
	 * @param quantity
	 * @throws PortfolioFullException 
	 */
	public void buyStock(Stock stock, int quantity) throws PortfolioFullException, BalanceException{
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
						throw new BalanceException();/*System.out.println("Not enough balance to complete purchase");*/
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
		if(!isOk){
			throw new PortfolioFullException();
		}
	}
	/**
	 * This method sells a specific stock by his symbol according to the given quantity.
	 * 
	 * @param symbol
	 * @param quantity
	 * @throws StockNotExistException 
	 */
	public void sellStock(String symbol, int quantity) throws StockNotExistException{
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
		if (!flag){
			throw new StockNotExistException();
		}
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
	public void updateBalance(float amount) throws BalanceException{
		
		if(amount < 0 && this.balance + amount < 0){
			throw new BalanceException();
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
	public StockInterface findStock(String symbol) {
		for(int i = 0 ; i < portfolioSize ; i++)
		{
			if(symbol.equals(this.stocks[i].getSymbol()))
					{
					return this.stocks[i];
					}
				
		}
		return null;
	}
	public static int getMaxSize() {
		return MAX_PORTFOLIO_SIZE;
	}
	
}
		
	
