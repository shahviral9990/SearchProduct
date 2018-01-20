package com.example.demo.dto;


import com.example.demo.entity.Product;
import com.example.demo.entity.ProductSearchOne;
import com.example.demo.entity.Seller;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


public class CategoryDto {
    public static final String COLLECTION_NAME = "category";

    private String categoryId;

    public static String getCollectionName() {
        return COLLECTION_NAME;
    }

    public List<CategoryDetailsDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<CategoryDetailsDTO> productList) {
        this.productList = productList;
    }

    private List<CategoryDetailsDTO> productList;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
