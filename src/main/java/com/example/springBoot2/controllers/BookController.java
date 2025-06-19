package com.example.springBoot2.controllers;

import com.example.springBoot2.Repositories.BookRepository;
import com.example.springBoot2.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable(value="id") int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @PostMapping("")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable(value="id") int bookId, @RequestBody Book book) {
        book.setId(bookId);
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable(value="id") int id) {
        bookRepository.findById(id).ifPresent(currBook -> bookRepository.deleteById(id));
    }

}
