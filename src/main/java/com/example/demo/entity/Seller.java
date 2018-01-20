package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Product.COLLECTION_NAME)
public class Seller {
    public static final String COLLECTION_NAME = "seller";
    private SellerDetails seller;
    private long price;
    private long rate;
    private long stock;

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public SellerDetails getSeller() {
        return seller;
    }

    public void setSeller(SellerDetails seller) {
        this.seller = seller;
    }


    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}

