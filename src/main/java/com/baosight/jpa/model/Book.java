package com.baosight.jpa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book")
@Data
@EqualsAndHashCode
@Accessors(chain = true)
//@NamedStoredProcedureQuery(name = "p_database01_book", procedureName = "p_database01_book")
@SuppressWarnings("all")
public class Book implements Serializable {

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
