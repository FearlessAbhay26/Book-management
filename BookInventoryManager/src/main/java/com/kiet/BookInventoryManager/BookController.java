package com.kiet.BookInventoryManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @GetMapping("/books/author/{name}")
    public List<Book> getBooksByAuthor(@PathVariable String name) {
        return bookRepository.findByAuthor(name);
    }

    @GetMapping("/books/available")
    public List<Book> getAvailableBooks() {
        return bookRepository.findByAvailableTrue();
    }

    @PostMapping("/book")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}