package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = SellerDetailsSearchOne.COLLECTION_NAME)
public class SellerDetailsSearchOne {
    public static final String COLLECTION_NAME = "seller";

    @Id
    String sellerId;
    String sellerName;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
