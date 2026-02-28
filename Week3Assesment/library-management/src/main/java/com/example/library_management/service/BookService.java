package com.example.library_management.service;

import com.example.library_management.exception.BookNotFoundException;
import com.example.library_management.model.Book;
import org.springframework.stereotype.Service;


import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();
    private int nextId = 1;

    public void addBook(Book book){
        book.setId(nextId++);
        books.add(book);
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book getBookById(int id){
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found"));
    }

    public void deleteBook(int id){
        Book book = getBookById(id);
        books.remove(book);
    }
}
