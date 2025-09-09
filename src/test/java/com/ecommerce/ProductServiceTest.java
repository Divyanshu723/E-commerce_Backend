package com.ecommerce;

import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.impl.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceTest {

    private ProductService productService;

    @Before
    public void setUp() {
        productService = new ProductServiceImpl();
    }

    @Test
    public void testAddAndGetProduct() {
        Product product = new Product(1, "Tablet", 20000);
        productService.addProduct(product);

        Product fetched = productService.getProductById(1);
        assertNotNull(fetched);
        assertEquals("Tablet", fetched.getName());
    }

    @Test
    public void testGetAllProducts() {
        productService.addProduct(new Product(1, "Tablet", 20000));
        productService.addProduct(new Product(2, "Monitor", 12000));

        List<Product> products = productService.getAllProducts();
        assertEquals(2, products.size());
    }
}
