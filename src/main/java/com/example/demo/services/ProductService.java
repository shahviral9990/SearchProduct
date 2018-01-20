package com.example.demo.services;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductSearchOne;

import java.util.List;

public interface ProductService {


    List<Product> findAll();

    Product findOne(String id);
}
