package com.coop.cashsends.exception;

public class CoopTransferException extends Exception {

	private static final long serialVersionUID = -470180507998010368L;

	public CoopTransferException() {
		super();
	}

	public CoopTransferException(final String message) {
		super(message);
	}		
}
