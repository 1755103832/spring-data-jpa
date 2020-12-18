package com.baosight.jpa.service;

import com.baosight.jpa.mapper.BookMapper;
import com.baosight.jpa.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> queryAll() {
        return bookMapper.findAll();
    }

    public List<Book> queryByBookName(String bookName) {
        if (!StringUtils.isEmpty(bookName)) {
            return bookMapper.findByBookName(bookName);
        }
        return null;
    }

    public List<Book> invokeProcedure(String bookName) {
        return bookMapper.invokeProcedure(bookName);
    }
}
