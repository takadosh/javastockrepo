package com.myorg.javacourse;

public class Stock {
	
	private static final int BUY = 0, SELL = 1, REMOVE = 2, HOLD = 3;
	private String symbol;
	private int recommendation;
	private int stockQuantity;
	private float ask;
	private float bid;
	private java.util.Date date;
	
	public Stock (String newSymbol, int newstockQuantity, float newBid, float newAsk, java.util.Date newDate, int newRecommendation){
		this.symbol = newSymbol;
		this.bid = newBid;
		this.ask = newAsk;
		this.date = newDate;
		this.recommendation = newRecommendation;
		this.stockQuantity = newstockQuantity;
	}
	
	public String getHtmlDescription(){
		return "<b>Stock symbol</b> : "+this.getSymbol()+", <b>ask</b> : "+this.getAsk()+", <b>Bid</b>: "+this.getBid()+", <b>Date</b>: "+this.getDateMonth()+"/"+this.getDateDay()+"/"+this.getDateYear(); 
	}
	public int getRecommendation(){
		return this.recommendation;
	}
	public void setRecommendation(int recommendation){
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
	public java.util.Date getDate() {
		return this.date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public int getDateDay(){
		return this.date.getDate();
	}
	public int getDateMonth(){
		return this.date.getMonth();
	}
	public int getDateYear(){
		return this.date.getYear();
	}
		
	
}
