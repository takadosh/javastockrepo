package com.myorg.javacourse;

import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Portfolio.ALGO_RECOMMENDATION;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class describes the stock's content.
 * @author TalKadosh
 */
public class Stock {

	private String symbol = null;
	private Portfolio.ALGO_RECOMMENDATION recommendation;
	private int stockQuantity = 0;
	private float ask = 0;
	private float bid = 0;
/*	private java.util.Date date;*/
	private Date date;

	
	public Stock (String symbol, float bid, float ask, Date date,ALGO_RECOMMENDATION recommendation){
		this.symbol = symbol;
		this.bid = bid;
		this.ask = ask;
		this.date = date;
		this.recommendation = recommendation;
	}
	public Stock(Stock stock){
		this.symbol = new String (stock.getSymbol());
		this.bid = stock.getBid();
		this.ask = stock.getAsk();
		this.date = new Date (stock.getDate().getTime());
		this.recommendation = stock.getRecommendation();
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
