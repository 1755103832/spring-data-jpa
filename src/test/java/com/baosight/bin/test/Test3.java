package com.baosight.bin.test;

import com.baosight.bin.jpa.mapper.BookMapper;
import com.baosight.bin.jpa.model.Book;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * @Author zyb
 * @Date Create in 2020/9/4 13:51
 * @Description
 **/
public class Test3 {

    private static BookMapper bookMapper;

    public static void main(String[] args) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("1", "I");
//        map.put("2", "like");
//        map.put("3", "java");
//        map.values().forEach(System.out::print);
        List<Book> bookList = bookMapper.findAll();
        Object parse = JSONArray.parse(bookList.toString());
        System.out.println(parse);
    }
}
