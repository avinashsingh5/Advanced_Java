package com.example.library_management.controller;

import org.springframework.ui.Model;
import com.example.library_management.model.Book;
import com.example.library_management.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/add-book")
    public String addBookPage(Model model){
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/add-book")
    public String addBook(
            @Valid @ModelAttribute("book") Book book,
            BindingResult result){

        if(result.hasErrors()){
            return "add-book";
        }

        bookService.addBook(book);
        return "redirect:/view-books";
    }

    @GetMapping("/view-books")
    public String viewBooks(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "view-books";
    }

    @GetMapping("/book/{id}")
    public String bookDetails(@PathVariable int id, Model model){

        model.addAttribute("book",
                bookService.getBookById(id));

        return "book-details";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){

        bookService.deleteBook(id);
        return "redirect:/view-books";
    }
}