package com.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.library.Models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByBookTitle(String bookTitle); 
}
