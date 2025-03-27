package com.library.Exception;

public class BookNotFoundException extends RuntimeException{
 private String message;
 public BookNotFoundException(String message) {
	 this.message=message;
 }
 public String getMessage() {
	 return message;
 }
}
