package com.library.Exception;

public class invalidBookDataException extends RuntimeException{
	private String message;
	public invalidBookDataException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}

}
