package com.example.demo.dto;

public class SellerDto {

    private long price;
    private SellerDetailsDto seller;

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

    public SellerDetailsDto getSeller() {
        return seller;
    }

    public void setSeller(SellerDetailsDto seller) {
        this.seller = seller;
    }


    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
