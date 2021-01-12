package com.baosight.jpa.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "t_product")
@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class Product implements Serializable {

    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "matcha_latte")
    private BigDecimal matchaLatte;

    @Column(name = "milk_tea")
    private BigDecimal milkTea;

    @Column(name = "cheese_cocoa")
    private BigDecimal cheeseCocoa;

    @Column(name = "walnut_brownie")
    private BigDecimal walnutBrownie;
}
