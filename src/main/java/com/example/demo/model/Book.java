package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import com.example.demo.model.Author;

@Entity
public class Book{
    private Long id;
    private String bookName;
    private Author author;

    public Book() {

    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(String bookName, Author author) {
        this.bookName = bookName;
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getbookName() {
        return bookName;
    }

    public void setbookName(String bookName) {
        this.bookName = bookName;
    }

    @ManyToOne
    @JoinColumn(name = "author_id")
    public  Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
