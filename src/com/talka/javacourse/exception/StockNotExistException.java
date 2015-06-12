package com.talka.javacourse.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class StockNotExistException extends PortfolioException{
	public StockNotExistException(){
		super("This stock does not exist");
	}

}
