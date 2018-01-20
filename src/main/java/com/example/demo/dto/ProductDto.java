package com.example.demo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDto {

    private List<SellerDto> sellerList;
    private String bestSellerId;
    private long bestSellerPrice;
    private Map<String, String> specsDetails;
    private String USP;

    public String getUSP() {
        return USP;
    }

    public void setUSP(String USP) {
        this.USP = USP;
    }

    public Map<String, String> getSpecsDetails() {
        return specsDetails;
    }

    public void setSpecsDetails(Map<String, String> specsDetails) {
        this.specsDetails = specsDetails;
    }


    public String getBestSellerId() {
        return bestSellerId;
    }

    public void setBestSellerId(String bestSellerId) {
        this.bestSellerId = bestSellerId;
    }

    public long getBestSellerPrice() {
        return bestSellerPrice;
    }

    public void setBestSellerPrice(long bestSellerPrice) {
        this.bestSellerPrice = bestSellerPrice;
    }

    private String productId;

    private String productName;

    private String imageUrl;

    public List<SellerDto> getSellerList() {
        return sellerList;
    }

    public void setSellerList(List<SellerDto> sellerList) {
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
