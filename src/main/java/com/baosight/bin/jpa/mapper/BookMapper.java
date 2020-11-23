package com.baosight.bin.jpa.mapper;

import com.baosight.bin.jpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author zyb
 * @Date 2020/7/2
 * @Description
 **/
public interface BookMapper extends JpaRepository<Book, Long> {

    @Query(value = "select * from book where book_name like concat('%',?,'%')", nativeQuery = true)
    List<Book> findByBookName(String bookName);
}
