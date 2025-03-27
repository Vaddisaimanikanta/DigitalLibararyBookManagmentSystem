package com.library.Controller;

import com.library.Exception.BookNotFoundException;
import com.library.Exception.invalidBookDataException;
import com.library.Models.Book;
import com.library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Display All Books
    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    // Show Add Book Form
    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    // Save New Book
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book, Model model) {
        try {
            bookService.addBook(book);
            return "redirect:/books";
        } catch (invalidBookDataException ex) {
            model.addAttribute("error", ex.getMessage());
            return "add-book";
        }
    }

    // Show Edit Book Form
    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "edit-book";
    }

    // Update Book
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book, Model model) {
        try {
            bookService.updateBook(id, book);
            return "redirect:/books";
        } catch (invalidBookDataException ex) {
            model.addAttribute("error", ex.getMessage());
            return "edit-book";
        }
    }

    // Delete Book
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, Model model) {
        try {
            bookService.deleteBook(id);
            model.addAttribute("books");
        } catch (BookNotFoundException e) {
            model.addAttribute("error", "Book deleted successfully!");
        }
        return "books";
    }

 // Search by Title
    @GetMapping("/search/title")
    public String searchBookByTitle(@RequestParam String title, Model model) {
        try {
            Book book = bookService.getBookByTitle(title);
            model.addAttribute("books", List.of(book));
        } catch (BookNotFoundException ex) {
            model.addAttribute("error", ex.getMessage());
        }
        return "books";
    }

    // Search by ID
    @GetMapping("/search/id")
    public String searchBookById(@RequestParam Long id, Model model) {
        try {
            Book book = bookService.getBookById(id);
            model.addAttribute("books", List.of(book));
        } catch (BookNotFoundException ex) {
            model.addAttribute("error", ex.getMessage());
        }
        return "books";
    }

}
