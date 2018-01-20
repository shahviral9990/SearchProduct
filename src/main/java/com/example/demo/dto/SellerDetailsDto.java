package com.example.demo.dto;

public class SellerDetailsDto {
    String sellerId;
    String sellerName;
    long rate;

    public long getRate() {
        return rate;
    }

    public void setRate(long rate) {
        this.rate = rate;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerID(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }


}
