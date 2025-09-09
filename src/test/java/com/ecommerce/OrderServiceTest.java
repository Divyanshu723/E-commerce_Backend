package com.ecommerce;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.Product;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.impl.OrderServiceImpl;
import com.ecommerce.service.impl.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServiceTest {

    private OrderService orderService;
    private ProductService productService;

    @Before
    public void setUp() {
        productService = new ProductServiceImpl();
        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
        orderServiceImpl.setProductService(productService);
        orderService = orderServiceImpl;

        productService.addProduct(new Product(1, "Laptop", 75000));
    }

    @Test
    public void testPlaceOrderSuccess() {
        Product p = productService.getProductById(1);
        Order order = new Order(101, p, 2);

        orderService.placeOrder(order);

        assertNotNull(orderService.getOrderById(101));
    }

    @Test
    public void testPlaceOrderFailure() {
        Product fake = new Product(99, "FakeProduct", 0);
        Order order = new Order(102, fake, 1);

        orderService.placeOrder(order);

        assertNull(orderService.getOrderById(102));
    }
}
