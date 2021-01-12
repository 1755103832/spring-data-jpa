package com.baosight.jpa.service;

import com.baosight.jpa.mapper.ProductMapper;
import com.baosight.jpa.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public List<Product> queryAll() {
        List<Product> productList = productMapper.findAll(Sort.sort(Product.class));
        return productList;
    }

}
