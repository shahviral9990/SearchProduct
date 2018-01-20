package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class CategoryDetails {
    @DBRef
    ProductSearchOne product;

    public ProductSearchOne getProduct() {
        return product;
    }

    public void setProduct(ProductSearchOne product) {
        this.product = product;
    }

}
