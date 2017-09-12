package com.example.demo.controllers;

import com.example.demo.model.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/Book/")
    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    @GetMapping("/Book/{bookName}")
    public List<Book> getBookByBookName(@PathVariable String bookName) {
        System.out.println("we are in book controller @GetMapping "+ bookName);
        return bookRepository.findBookByBookName(bookName);
    }

    @PostMapping("/Book/")
    public void saveBook(@ModelAttribute Book book) {
        System.out.println("we are in book controller  @PostMapping "+ book);
        bookRepository.save(book);
    }
}
