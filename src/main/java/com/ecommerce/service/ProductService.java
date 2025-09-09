package com.ecommerce.service;

import com.ecommerce.entity.Product;
import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    Product getProductById(int id);
    List<Product> getAllProducts();
}
