package com.baosight.jpa.controller;

import com.baosight.jpa.model.Book;
import com.baosight.jpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> query1() {
        return bookService.queryAll();
    }

    @GetMapping("/all2")
    public Map<String, Object> query2() {
        List<Book> bookList = bookService.queryAll();
        Map<String, Object> map = new ConcurrentHashMap<>();
        if (null != bookList && bookList.size() > 0) {
            map.put("bookList", bookList);
        }
        return map;
    }

}
