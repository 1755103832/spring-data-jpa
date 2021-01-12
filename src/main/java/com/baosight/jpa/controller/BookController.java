package com.baosight.jpa.controller;

import com.baosight.jpa.model.Book;
import com.baosight.jpa.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@Api(tags = "图书信息接口")
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @GetMapping("/all")
    @ApiOperation(value = "返回所有图书信息")
    public List<Book> query1() {
        return bookService.queryAll();
    }

    @GetMapping("/all2")
    @ApiOperation(value = "返回带字符串的所有图书信息")
    public Map<String, Object> query2() {
        List<Book> bookList = bookService.queryAll();
        Map<String, Object> map = new ConcurrentHashMap<>();
        if (null != bookList && bookList.size() > 0) {
            map.put("bookList", bookList);
        }
        return map;
    }

    @PostMapping("/all3")
    @ApiOperation(value = "返回带字符串的根据图书名称模糊查")
    public Map<String, Object> query3(String bookName) {
        List<Book> bookList = bookService.queryByBookName(bookName);
        Map<String, Object> map = new ConcurrentHashMap<>();
        if (null != bookList && bookList.size() > 0) {
            map.put("fuzzyBookList", bookList);
        }
        return map;
    }

    @PostMapping("/all4")
    @ApiOperation(value = "测试springdatajpa调用存储过程")
    public List<Book> query4(String bookName) {
        return bookService.invokeProcedure(bookName);
    }

//    @GetMapping("/send/{input}")
//    public void sendFoo(@PathVariable String input) {
//        this.kafkaTemplate.send("topic_input", input);
//    }
//
//    @KafkaListener(id = "webGroup", topics = "topic_input")
//    public void listen(String input) {
//        LOGGER.info("input value:{}", input);
//    }

}
