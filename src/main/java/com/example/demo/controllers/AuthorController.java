package com.example.demo.controllers;
import com.example.demo.model.Author;

import com.example.demo.repositories.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
public class AuthorController {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/Author/")
    public List<Author> getAuthor() {
        return authorRepository.findAll();
    }

    @GetMapping("/Author/{firstName}")
    public List<Author> getAuthorByFirstName(@PathVariable String firstName) {
        return authorRepository.findByFirstNameOrderByLastNameDesc(firstName);
    }

    @PostMapping("/Author/")
    public void saveEmployee(@PathVariable Author author) {
        authorRepository.save(author);
    }

}