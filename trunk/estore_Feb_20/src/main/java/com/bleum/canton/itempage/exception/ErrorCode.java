package com.bleum.canton.itempage.exception;

public class ErrorCode {
	private int errorCode;
	private String message;

	public ErrorCode(int code, String message) {

		this.errorCode = code;
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

}
