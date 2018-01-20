package com.example.demo.services.impl;


import com.example.demo.entity.Product;
import com.example.demo.entity.ProductSearchOne;
import com.example.demo.repository.ProductRepository;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOne(String id) {
        return productRepository.findOne(id);
    }

}
