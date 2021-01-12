package com.baosight.jpa.mapper;

import com.baosight.jpa.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMapper extends JpaRepository<Product, String> {

}
