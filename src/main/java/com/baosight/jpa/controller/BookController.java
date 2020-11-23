package com.baosight.jpa.controller;

import com.baosight.jpa.model.Book;
import com.baosight.jpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> query1() {
        return bookService.queryAll();
    }

}
