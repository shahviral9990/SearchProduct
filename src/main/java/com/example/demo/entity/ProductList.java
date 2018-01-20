package com.example.demo.entity;

import com.example.demo.dto.ProductData;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.HashMap;

@Document(collection = "productList")
public class ProductList {

    @Field("data")
    ArrayList<ProductData> data;

    public ArrayList<ProductData> getData() {
        return data;
    }

    public void setData(ArrayList<ProductData> data) {
        this.data = data;
    }
}
