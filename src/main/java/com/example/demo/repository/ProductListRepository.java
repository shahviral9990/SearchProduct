package com.example.demo.repository;

import com.example.demo.entity.ProductList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface ProductListRepository extends MongoRepository<ProductList, String> {

}
