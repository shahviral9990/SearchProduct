package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = ProductSearchOne.COLLECTION_NAME)
public class SellerSearchOne {
    public static final String COLLECTION_NAME = "seller";


    private SellerDetailsSearchOne seller;
    private long price;


    public SellerDetailsSearchOne getSeller() {
        return seller;
    }

    public void setSeller(SellerDetailsSearchOne seller) {
        this.seller = seller;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}

