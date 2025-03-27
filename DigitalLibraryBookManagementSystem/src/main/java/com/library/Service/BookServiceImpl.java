package com.library.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.Exception.BookNotFoundException;
import com.library.Exception.invalidBookDataException;
import com.library.Models.Book;
import com.library.Repository.BookRepository;
@Service
public class BookServiceImpl implements BookService{
	@Autowired
    private BookRepository bookRepository;
	@Override
	public List<Book> getAllBooks() {
	   return bookRepository.findAll();
	}
	@Override
	public Book addBook(Book book) {
	    validateBook(book);
	    return bookRepository.save(book);
	}

	@Override
	public Book getBookById(Long id) {
	    Optional<Book> book = bookRepository.findById(id);
	    if (book.isPresent()) {
	        return book.get();
	    } else {
	        throw new BookNotFoundException("Book not found with ID: " + id);
	    }
	}

	@Override
	public Book getBookByTitle(String title) {
	      Book b=bookRepository.findByBookTitle(title);
	      if(b!=null) {
	    	  return b;
	      }
		  throw new BookNotFoundException("Book not found with Title: "+title);
	}
	@Override
	public Book updateBook(Long id, Book book) {
		    Book existingBook = getBookById(id);
	        validateBook(book);
	        existingBook.setBookTitle(book.getBookTitle());
	        existingBook.setBookAuthor(book.getBookAuthor());
	        existingBook.setBookGenre(book.getBookGenre());
	        existingBook.setBookAvailabilityStatus(book.getBookAvailabilityStatus());
	        return bookRepository.save(existingBook);
	}

	@Override
	public void deleteBook(Long id) {
		if(bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
		}
		throw new BookNotFoundException("Book not found with the Id: "+id);
		
	}
	  private void validateBook(Book book) {
	        if (book.getBookTitle() == null || book.getBookTitle().trim().isEmpty()) {
	            throw new invalidBookDataException("Title cannot be empty");
	        }
	        if (book.getBookAuthor()== null || book.getBookAuthor().trim().isEmpty()) {
	            throw new invalidBookDataException("Author cannot be empty");
	        }
	        if (!"Available".equalsIgnoreCase(book.getBookAvailabilityStatus()) &&
	                !"Checked Out".equalsIgnoreCase(book.getBookAvailabilityStatus())) {
	            throw new invalidBookDataException("Availability must be 'Available' or 'Checked Out'");
	        }
	    }

}
