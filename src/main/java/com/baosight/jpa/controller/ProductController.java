package com.baosight.jpa.controller;

import com.baosight.jpa.model.Product;
import com.baosight.jpa.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "echarts_share_dataset测试接口")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productAll")
    @ApiOperation(value = "返回测试接口信息")
    public List<Product> getAll() {
        return productService.queryAll();
    }

    @GetMapping("/product")
    @ApiOperation(value = "返回产品接口信息")
    public List<Product> getproductAll() {
        List<Product> productList = productService.queryAll();
        List<String> productIdList = productList.stream().map(Product::getProductId).collect(Collectors.toList());
        System.out.println("productId-->" + productIdList);
        List<BigDecimal> matchaLatteList = productList.stream().map(Product::getMatchaLatte).collect(Collectors.toList());
        System.out.println("matchaLatte-->" + matchaLatteList);
        List<BigDecimal> milkTeaList = productList.stream().map(Product::getMilkTea).collect(Collectors.toList());
        System.out.println("milkTea-->" + milkTeaList);
        List<BigDecimal> cheeseCocoaList = productList.stream().map(Product::getCheeseCocoa).collect(Collectors.toList());
        System.out.println("cheeseCocoa-->" + cheeseCocoaList);
        List<BigDecimal> walnutBrownieList = productList.stream().map(Product::getWalnutBrownie).collect(Collectors.toList());
        System.out.println("walnutBrownie-->" + walnutBrownieList);
        return productService.queryAll();
    }

    @GetMapping("/productId")
    @ApiOperation(value = "返回productId字段")
    public List<String> getProductId() {
        return productService.queryAll().stream().map(Product::getProductId).collect(Collectors.toList());
    }

    @GetMapping("/matchaLatte")
    @ApiOperation(value = "返回matchaLatte字段")
    public List<BigDecimal> getMatchaLatte() {
        return productService.queryAll().stream().map(Product::getMatchaLatte).collect(Collectors.toList());
    }

    @GetMapping("/milkTea")
    @ApiOperation(value = "返回milkTea字段")
    public List<BigDecimal> getMilkTea() {
        return productService.queryAll().stream().map(Product::getMilkTea).collect(Collectors.toList());
    }

    @GetMapping("/cheeseCocoa")
    @ApiOperation(value = "返回cheeseCocoa字段")
    public List<BigDecimal> getCheeseCocoa() {
        return productService.queryAll().stream().map(Product::getCheeseCocoa).collect(Collectors.toList());
    }

    @GetMapping("/walnutBrownie")
    @ApiOperation(value = "返回walnutBrownie字段")
    public List<BigDecimal> getWalnutBrownie() {
        return productService.queryAll().stream().map(Product::getWalnutBrownie).collect(Collectors.toList());
    }

}
