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

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //移位添加注释,提高性能
//        int num = 8 >> 2;//除4
//        int num = 8 / 4;
        int num = 2 << 3;//乘8
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间-->" + (endTime - startTime) + "ms" + num);
    }
}
