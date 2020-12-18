package com.baosight.jpa.mapper;

import com.baosight.jpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SuppressWarnings("all")
//@Repository
public interface BookMapper extends JpaRepository<Book, Long> {

    /**
     * @Author zyb
     * @Description 本地测试 fuzzy query
     * @Datetime 2020/12/15 10:04
     * @Param [bookName]
     * @Return java.util.List<com.baosight.jpa.model.Book>
     **/
    @Query(value = "select id, book_name, book_price from book where book_name like concat('%',?,'%')", nativeQuery = true)
    List<Book> findByBookName(String bookName);

    //@Procedure(name = "p_database01_book")
    @Query(value = "call database01.p_database01_book(concat('%',:bookName,'%'))", nativeQuery = true)
    List<Book> invokeProcedure(@Param("bookName") String bookName);
}
