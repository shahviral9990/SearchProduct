package com.example.demo.dto;


import com.example.demo.entity.SellerSearchOne;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public class ProductSearchOneDto {

    private List<SellerSearchOne> sellerList;


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
