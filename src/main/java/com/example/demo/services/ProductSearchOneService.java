package com.example.demo.services;

import com.example.demo.entity.ProductSearchOne;

import java.util.List;

public interface ProductSearchOneService {

    List<ProductSearchOne> findAll();

    ProductSearchOne findOne(String id);

}


