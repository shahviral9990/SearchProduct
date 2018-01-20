package com.example.demo.controller;

import com.example.demo.dto.*;

import com.example.demo.entity.*;
import com.example.demo.dto.Response;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductListService;
import com.example.demo.services.ProductSearchOneService;
import com.example.demo.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@RestController
public class ProductController {

    static Map<String, Float> map = new LinkedHashMap<String, Float>();
    static Map<String, Long> p = new HashMap<String, Long>();

    @Autowired
    ProductService productService;

    @Autowired
    ProductSearchOneService productSearchOneService;
    @Autowired
    ProductListService productListService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, value = "/randomSearch")
    public ResponseEntity<List<ProductSearchOneDto>> getAllProducts() {
        List<ProductSearchOne> productList = productSearchOneService.findAll();

        List<ProductSearchOneDto> productDtos = new ArrayList<>();
        int i = 0;
        for (ProductSearchOne product : productList) {
            ProductSearchOneDto productDto = new ProductSearchOneDto();
            BeanUtils.copyProperties(product, productDto);
            productDtos.add(productDto);
            i++;
            if (i == 6)
                break;
        }


        return new ResponseEntity<List<ProductSearchOneDto>>(productDtos, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/allDetails/{prodId}")
    public ResponseEntity<?> getAllDeatils(@PathVariable("prodId") String id) {
        //  id="5a5df579d5046d34a2b1d1b6";
        map.clear();
        p.clear();
        Product product = productService.findOne(id);
        List<Seller> list = new ArrayList<Seller>();
        list = product.getSellerList();
        SellerDetails si = new SellerDetails();
        float price = 0, rate_seller = 0, rate_customer = 0, stock = 0, size = 0;
        rate_customer += si.getRate();
        for (Seller li : list) {
            size = list.size();
            price += li.getPrice();
            rate_seller += li.getRate();
            stock += li.getStock();
            si = li.getSeller();
            weightedMean(new float[]{price, rate_customer, rate_seller, stock, size}, new int[]{5, 4, 3, 2, 1}, 5, si.getSellerId());
            p.put(si.getSellerId(), li.getPrice());
        }

        for (String ob : map.keySet()) {
            product.setBestSellerId(ob);
            product.setBestSellerPrice(p.get(ob));
            break;
        }


        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);


    }


    @RequestMapping(method = RequestMethod.GET, value = "/searchOne/{id}")
    public ResponseEntity<List<ProductSearchOneDto>> searchOne(@PathVariable String id) {

        RestTemplate restTemplate = new RestTemplate();
        List<ProductSearchOneDto> list = new ArrayList<ProductSearchOneDto>();

        try {
            ArrayList<String> ids = restTemplate.getForObject("http://10.177.7.79:8080/solr/" + id, ArrayList.class);
            for (String i : ids) {


                ProductSearchOne product = productSearchOneService.findOne(i);
                ProductSearchOneDto productDto = new ProductSearchOneDto();

                BeanUtils.copyProperties(product, productDto);
                list.add(productDto);
            }

        } catch (Exception e) {

        }

        return new ResponseEntity<List<ProductSearchOneDto>>(list, HttpStatus.OK);

    }

    static void weightedMean(float[] X, int[] W, int n, String si) {
        int sum = 0, numWeight = 0;

        for (int i = 0; i < n; i++) {
            numWeight = (int) (numWeight + X[i] * W[i]);
            sum += W[i];
        }

        map.put(si, (float) (numWeight) / sum);
        Set<Map.Entry<String, Float>> set = map.entrySet();
        List<Map.Entry<String, Float>> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Float>>() {
            public int compare(Map.Entry<String, Float> o1, Map.Entry<String, Float> o2) {
                if (o1 == null || o1.getValue() == null)
                    return -1;
                else if (o2 == null || o2.getValue() == null)
                    return 1;
                else
                    return o1.getValue().compareTo(o2.getValue());
            }
        });


    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchCategory/{categoryName}")
    public ResponseEntity<CategoryDto> searchByCategory(@PathVariable("categoryName") String id) {
        Category category = categoryService.findOne(id);
        CategoryDto categoryDto = new CategoryDto();
        BeanUtils.copyProperties(category, categoryDto);
        return new ResponseEntity<CategoryDto>(categoryDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/productList")
    public ResponseEntity<ProductList> productList() {


        return new ResponseEntity<ProductList>(productListService.getAllProductList(), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/cartDetails")
    public ResponseEntity<Response> cartDetails(@RequestBody List<CartDto> obj) throws IOException {
        // List <CartDto> obj=new ArrayList<>();
        int flag = 0;
        Response r = new Response();
        r.setStatus(true);
        List<CartResultDto> result = new ArrayList<>();
        for (CartDto cartDto : obj) {
            CartResultDto cartResultDto = new CartResultDto();
            Product product = productService.findOne(cartDto.getProductId());
            product.setProductId(cartDto.getProductId());
            List<Seller> list = product.getSellerList();

            for (Seller li : list) {
                SellerDetails sellerDetails = li.getSeller();
                if (sellerDetails.getSellerId().equals(cartDto.getSellerId())) {
                    if (cartDto.getQuantity() <= li.getStock()) {
                        cartResultDto.setStatus(true);
                        cartResultDto.setProductId(cartDto.getProductId());
                        cartResultDto.setQuantity(cartDto.getQuantity());
                        cartResultDto.setPrice(li.getPrice()*cartDto.getQuantity());
                        cartResultDto.setImageUrl(product.getImageUrl());
                        cartResultDto.setProductName(product.getProductName());
                        cartResultDto.setSellerId(sellerDetails.getSellerId());
                        cartResultDto.setSellerName(sellerDetails.getSellerName());
                        cartResultDto.setUserId(cartDto.getCartId());
                        result.add(cartResultDto);

                    } else {

                        flag = 1;
                        r.setStatus(false);
                        r.setProductId(cartDto.getProductId());
                        r.setStock(Integer.parseInt(li.getStock() + ""));
                        //  result.add(cartResultDto);
                    }
                }
            }
        }
        if (flag == 0) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                Boolean response = restTemplate.postForObject("http://10.177.7.124:8080/order/generateOrder", result, Boolean.class);
            } catch (Exception e) {

            }
        } else {

        }
        return new ResponseEntity<Response>(r, HttpStatus.OK);


    }

}







