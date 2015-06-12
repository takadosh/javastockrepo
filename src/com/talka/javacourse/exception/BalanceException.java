package com.talka.javacourse.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class BalanceException extends PortfolioException{
	public BalanceException(){
		super("Changing balance to negative amount is illegal");
	}
}
