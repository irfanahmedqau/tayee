package com.bleum.canton.checkout.exception;

public class ErrorCode {
	private int errorCode;
	private String message;

	private ErrorCode(int errorCode, String message) {

		this.errorCode = errorCode;
		this.message = message;
	}

	public int getErrorCode() {

		return errorCode;
	}

	public String getMessage() {

		return message;
	}
}