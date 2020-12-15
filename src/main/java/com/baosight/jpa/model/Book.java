package com.baosight.jpa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@SuppressWarnings("all")
public class Book {

    // 主键
    @Id
    // 自增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_price")
    private String bookPrice;

}
