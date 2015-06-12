package com.talka.javacourse.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class PortfolioFullException extends PortfolioException{
	public PortfolioFullException(){
		super("The portfolio has got to its max stocks amount, please delete before you try to add");
	}
	
}
