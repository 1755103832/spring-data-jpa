package com.baosight.bin.jpa.service;

import com.baosight.bin.jpa.mapper.BookMapper;
import com.baosight.bin.jpa.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author zyb
 * @Date 2020/7/2
 * @Description
 **/
@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    /**
     * @Author zyb
     * @Description
     * @Date 2020/7/2 10:33
     * @Param []
     * @Return java.util.List<com.aaa.bin.jpa.model.Book>
     **/
    public List<Book> queryBooks() {
        return null != bookMapper && !"".equals(bookMapper) ? bookMapper.findAll() : null;
    }

    /**
     * @Author zyb
     * @Description
     * @Date 2020/7/2 15:01
     * @Param [id]
     * @Return java.util.Optional<com.aaa.bin.jpa.model.Book>
     **/
    public Optional<Book> queryBooksById(Long id) {
        return null != bookMapper && !"".equals(bookMapper) ? bookMapper.findById(id) : Optional.empty();
    }

    /**
     * @Author zyb
     * @Description
     * @Date 2020/7/2 15:20
     * @Param []
     * @Return com.aaa.bin.jpa.model.Book
     **/
    public Book saveBook() {
        Book book = new Book();
        book.setBookName("spring-data-jpa");
        book.setBookPrice("101.93");
        return null != bookMapper && !"".equals(bookMapper) ? bookMapper.saveAndFlush(book) : null;
    }

    /**
     * @Author zyb
     * @Description
     * @Date 2020/7/2 16:02
     * @Param []
     * @Return com.aaa.bin.jpa.model.Book
     **/
    public Book modifyBookInfo() {
        Book book = new Book();
        book.setId(11L);
        book.setBookName("spring-data-jpa");
        book.setBookPrice("100.99");
        return null != bookMapper && !"".equals(bookMapper) ? bookMapper.saveAndFlush(book) : null;
    }

    /**
     * @Author zyb
     * @Description
     * @Date 2020/7/2 16:14
     * @Param [id]
     * @Return void
     **/
    public void delBookById(Long id) {
        if (null != bookMapper && !"".equals(bookMapper)) {
            bookMapper.deleteById(id);
        }
    }

    /**
     * @Author zyb
     * @Description
     * @Date 2020/7/2 16:22
     * @Param [book]
     * @Return com.aaa.bin.jpa.model.Book
     **/
    public Book currentAdd(Book book) {
        return null != bookMapper && !"".equals(bookMapper) ? bookMapper.saveAndFlush(book) : null;
    }

    /**
     * @Author zyb
     * @Description
     * @Date 2020/7/2 16:49
     * @Param [bookName]
     * @Return java.util.List<com.aaa.bin.jpa.model.Book>
     **/
    public List<Book> fuzzyQueryBook(String bookName) {
        return null != bookMapper && !"".equals(bookMapper) ? bookMapper.findByBookName(bookName) : null;
    }

    /**
     * @Author zyb
     * @Description test lambda
     * @Datetime 2020/8/17 15:58
     * @Param []
     * @Return java.util.List<com.aaa.bin.jpa.model.Book>
     **/
//    public List<Book> lambdaQuery() {
//        List<Book> bookList = bookMapper.findAll();
//        List<String> stringList = bookList.stream()
//                .map(book -> book.getBookName())
//                .distinct()
//                .collect(Collectors.toList());
//        return stringList;
//    }

    /**
     * @Author zyb
     * @Description 返回条数
     * @Datetime 2020/9/4 15:58
     * @Param []
     * @Return java.lang.Long
     **/
    public Long bookCount() {
        return bookMapper.count();
    }
}
