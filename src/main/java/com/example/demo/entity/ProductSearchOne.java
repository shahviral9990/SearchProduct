package com.example.demo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = ProductSearchOne.COLLECTION_NAME)
public class ProductSearchOne {
    public static final String COLLECTION_NAME = "product";


    @DBRef
    @Field("sellerList")
    private List<SellerSearchOne> sellerList;


    @Id
    private String productId;

    private String productName;
    //  @Field("imageUrl")
    private String imageUrl;

    public List<SellerSearchOne> getSellerList() {
        return sellerList;
    }

    public void setSellerList(List<SellerSearchOne> sellerList) {
        this.sellerList = sellerList;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
