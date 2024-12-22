package com.teachmeskills.lesson_23.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "books")
public class BookListWrapper {
    private Book[] books;

    public BookListWrapper() {}

    public BookListWrapper(Book[] books) {
        this.books = books;
    }
    @XmlElement(name = "book")
    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}

