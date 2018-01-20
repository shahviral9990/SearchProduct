package com.example.demo.services.impl;

import com.example.demo.entity.ProductSearchOne;
import com.example.demo.repository.ProductSearchOneRepository;
import com.example.demo.services.ProductSearchOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSearchOneServiceImpl implements ProductSearchOneService {
    @Autowired
    ProductSearchOneRepository productSearchOneRepository;

    @Override
    public List<ProductSearchOne> findAll() {
        return productSearchOneRepository.findAll();
    }

    @Override
    public ProductSearchOne findOne(String id) {
        return productSearchOneRepository.findOne(id);
    }
}
