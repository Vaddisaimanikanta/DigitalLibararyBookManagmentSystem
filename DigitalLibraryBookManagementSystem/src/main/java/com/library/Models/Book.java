package com.library.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long bookId;
	    private String bookTitle;
	    private String bookAuthor;
	    private String bookGenre;
	    private String bookAvailabilityStatus;
	    public Book() {
	    	
	    }
		public Book(Long bookId, String bookTitle, String bookAuthor, String bookGenre, String bookAvailabilityStatus) {
			this.bookId = bookId;
			this.bookTitle = bookTitle;
			this.bookAuthor = bookAuthor;
			this.bookGenre = bookGenre;
			this.bookAvailabilityStatus = bookAvailabilityStatus;
		}
		public Long getBookId() {
			return bookId;
		}
		public void setBookId(Long bookId) {
			this.bookId = bookId;
		}
		public String getBookTitle() {
			return bookTitle;
		}
		public void setBookTitle(String bookTitle) {
			this.bookTitle = bookTitle;
		}
		public String getBookAuthor() {
			return bookAuthor;
		}
		public void setBookAuthor(String bookAuthor) {
			this.bookAuthor = bookAuthor;
		}
		public String getBookGenre() {
			return bookGenre;
		}
		public void setBookGenre(String bookGenre) {
			this.bookGenre = bookGenre;
		}
		public String getBookAvailabilityStatus() {
			return bookAvailabilityStatus;
		}
		public void setBookAvailabilityStatus(String bookAvailabilityStatus) {
			this.bookAvailabilityStatus = bookAvailabilityStatus;
		}	    
}
