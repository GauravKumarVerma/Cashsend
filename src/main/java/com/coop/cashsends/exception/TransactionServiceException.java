package com.coop.cashsends.exception;

public class TransactionServiceException extends Exception {

	private static final long serialVersionUID = -470180507998010368L;

	public TransactionServiceException() {
		super();
	}

	public TransactionServiceException(final String message) {
		super(message);
	}		

}
