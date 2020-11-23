package com.baosight.jpa.mapper;

import com.baosight.jpa.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("all")
public interface BookMapper extends JpaRepository<Book, Long> {

}
