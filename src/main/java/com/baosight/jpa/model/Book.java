package com.baosight.jpa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@SuppressWarnings("all")
public class Book {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_price")
    private String bookPrice;

}
