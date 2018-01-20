package com.example.demo.repository;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductSearchOne;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSearchOneRepository extends MongoRepository<ProductSearchOne, String> {
}
