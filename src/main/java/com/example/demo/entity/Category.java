package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = Category.COLLECTION_NAME)
public class Category {
    public static final String COLLECTION_NAME = "category";

    @Id
    private String categoryId;

    @DBRef
    private List<CategoryDetails> productList;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public static String getCollectionName() {
        return COLLECTION_NAME;
    }

    public List<CategoryDetails> getProductList() {
        return productList;
    }

    public void setProductList(List<CategoryDetails> productList) {
        this.productList = productList;
    }
}
