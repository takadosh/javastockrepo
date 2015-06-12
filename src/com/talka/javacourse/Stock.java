package com.talka.javacourse;

import com.talka.javacourse.model.Portfolio;
import com.talka.javacourse.model.Portfolio.ALGO_RECOMMENDATION;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.algo.model.StockInterface;
/**
 * This class describes the stock's content.
 * @author TalKadosh
 */
public class Stock implements StockInterface{

	private String symbol = null;
	private Portfolio.ALGO_RECOMMENDATION recommendation;
	private int stockQuantity = 0;
	private float ask = 0;
	private float bid = 0;
	private Date date;

	
	public Stock (String symbol, float bid, float ask, Date date,ALGO_RECOMMENDATION recommendation){
		this.symbol = symbol;
		this.bid = bid;
		this.ask = ask;
		this.date = date;
		this.recommendation = recommendation;
	}
	public Stock(Stock stock){
		this(new String(stock.getSymbol()), stock.getBid(), stock.getAsk(),
				new Date(stock.getDate().getTime()), stock.getRecommendation());
		this.stockQuantity = stock.getStockQuantity();
	}
	public Stock(){
		this.symbol = new String();
		this.ask = 0;
		this.bid = 0;
		this.date = new Date();
		this.recommendation = ALGO_RECOMMENDATION.HOLD;
		this.stockQuantity = 0;
	}
	
	/**
	 * This method returns a string of the stock's details with a HTML code.
	 * 
	 */
	
	public String getHtmlDescription(){
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
 		String dateStr = df.format(getDate());
		
		return "<b>Stock symbol</b> : " +this.getSymbol()+
				", <b>ask</b> : " +this.getAsk()+
				", <b>Bid</b>: "+this.getBid()+
				", <b>Date</b>: "+dateStr+
				", <b>quantity</b>: "+this.getStockQuantity();
	}
	public ALGO_RECOMMENDATION getRecommendation(){
		return this.recommendation;
	}
	public void setRecommendation(ALGO_RECOMMENDATION recommendation){
		this.recommendation = recommendation;
	}
	public int getStockQuantity(){
		return this.stockQuantity;
	}
	public void setStockQuantity(int stockQuantity){
		this.stockQuantity = stockQuantity;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return this.ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return this.bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
