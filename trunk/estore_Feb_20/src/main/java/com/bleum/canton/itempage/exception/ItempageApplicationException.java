package com.bleum.canton.itempage.exception;

import java.text.MessageFormat;

import com.bleum.canton.checkout.exception.ErrorCode;

public class ItempageApplicationException extends Exception {
	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;
	String details;
	public ItempageApplicationException(ErrorCode errorCode) {

		super(errorCode.getMessage());

		this.errorCode = errorCode;
	}

	public ItempageApplicationException(ErrorCode errorCode, String[] tokens) {

		super(getErrorMessage(errorCode, tokens));

		this.errorCode = errorCode;
	}
	
	public ItempageApplicationException(ErrorCode errorCode, String details) {

		super(errorCode.getMessage());

		this.errorCode = errorCode;
		this.details = details;
	}

	public ItempageApplicationException(ErrorCode errorCode, Throwable cause) {

		super(errorCode.getMessage(), cause);

		this.errorCode = errorCode;
	}

	public ItempageApplicationException(ErrorCode errorCode, String details, Throwable cause) {

		super(errorCode.getMessage(), cause);

		this.errorCode = errorCode;
		this.details = details;
	}

	public ItempageApplicationException(ErrorCode errorCode, String[] tokens, Throwable cause) {

		super(getErrorMessage(errorCode, tokens), cause);

		this.errorCode = errorCode;
	}

	public int getErrorCodeEnum() {

		return this.errorCode.getErrorCode();
	}

	private static String getErrorMessage(ErrorCode errorCode, Object[] tokens) {

		return MessageFormat.format(errorCode.getMessage(), tokens);
	}
	
	
	
	
	
}
