package com.example.demo.entity;


import com.example.demo.dto.SellerDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

@Document(collection = Product.COLLECTION_NAME)
public class Product {
    public static final String COLLECTION_NAME = "product";
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

    @DBRef
    private List<Seller> sellerList;

    public List<Seller> getSellerList() {
        return sellerList;
    }

    public void setSellerList(List<Seller> sellerList) {
        this.sellerList = sellerList;
    }

    @Id
    private String productId;

    private String productName;
    @Field("imageUrl")
    private String imageUrl;

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
