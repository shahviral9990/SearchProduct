package com.example.demo.dto;

import com.example.demo.entity.ProductSearchOne;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class CategoryDetailsDTO {
    @DBRef
    ProductSearchOne product;

    public ProductSearchOne getProduct() {
        return product;
    }

    public void setProduct(ProductSearchOne product) {
        this.product = product;
    }

}
