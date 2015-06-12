package com.talka.javacourse.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class StockAlreadyExistsException extends PortfolioException{
	public StockAlreadyExistsException(){
		super("This stock already exists");
	}

}
