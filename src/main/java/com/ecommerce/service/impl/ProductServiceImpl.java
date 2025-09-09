package com.ecommerce.service.impl;

import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final List<Product> productList = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        productList.add(product);
        System.out.println("Product added: " + product);
    }

    @Override
    public Product getProductById(int id) {
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }
}
