package com.example.demo.dto;


import com.example.demo.entity.SellerDetails;
import com.example.demo.entity.SellerDetailsSearchOne;

public class SellerSearchOneDto {
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

