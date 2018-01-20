package com.example.demo.repository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
    Category findByCategoryId(String id);
}
