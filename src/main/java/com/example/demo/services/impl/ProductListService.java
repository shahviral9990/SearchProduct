package com.example.demo.services.impl;

import com.example.demo.dto.ProductData;
import com.example.demo.dto.ProductListDTO;
import com.example.demo.entity.ProductList;
import com.example.demo.repository.ProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductListService implements com.example.demo.services.ProductListService {
    @Autowired
    ProductListRepository productListRepository;

    @Override
    public ProductList getAllProductList() {
        ProductList temp = productListRepository.findAll().get(0);
        ArrayList<String> data = new ArrayList<>();
        for (ProductData pData : temp.getData()) {
            data.add(pData.getKey());
        }
        return temp;
    }
}
