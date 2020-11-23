package com.baosight.bin.jpa.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baosight.bin.jpa.utils.ExcelCell;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author zyb
 * @Date 2020/7/1
 * @Description
 **/
@SuppressWarnings("all")
@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    //strategy=GenerationType.IDENTITY 自增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ExcelProperty("图书编号")
    //@ExcelCell(index = 0)
    private Long id;
    //@ExcelCell(index = 1)
    @ExcelProperty("图书名称")
    @Column(name = "book_name")
    private String bookName;
    //@ExcelCell(index = 2)
    @Column(name = "book_price")
    @ExcelProperty("图书价格")
    private String bookPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }
}
