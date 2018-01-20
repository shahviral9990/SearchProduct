package com.example.demo.dto;

import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

public class ProductData implements Serializable {
    @Field("key")
    String key;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
