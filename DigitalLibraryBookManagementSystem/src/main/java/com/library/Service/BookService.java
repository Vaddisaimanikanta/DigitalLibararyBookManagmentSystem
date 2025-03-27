package com.library.Service;

import java.util.List;

import com.library.Models.Book;

public interface BookService {
	    List<Book> getAllBooks();
	    Book getBookById(Long id);
	    Book getBookByTitle(String title);
	    Book addBook(Book book);
	    Book updateBook(Long id, Book book);
	    void deleteBook(Long id);
}
