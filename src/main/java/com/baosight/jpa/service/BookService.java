package com.baosight.jpa.service;

import com.baosight.jpa.mapper.BookMapper;
import com.baosight.jpa.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> queryAll() {
//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        List<Book> bookList = bookMapper.findAll();
        List<Book> bookList1 = bookList.stream().filter(str -> !str.toString().isEmpty()).collect(Collectors.toList());
        System.out.println(bookList1);
        return bookList1;
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
//        Book book = new Book();
//        book.setBookName("小黄书").setBookPrice("99.99");
//        JSONArray bookJson = JSONArray.parseArray(book.toString());
//        Map<String, String> map = new HashMap<>();
//        map.put("phoneBrand", "iphone12");
//        map.put("phonePrice", "6799");
//        bookJson.add(map);
//        System.out.println(bookJson);
        // java8新特性-datetime api
//        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println(format);

    }
}
