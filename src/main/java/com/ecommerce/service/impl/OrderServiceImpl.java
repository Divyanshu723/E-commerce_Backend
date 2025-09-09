package com.ecommerce.service.impl;

import com.ecommerce.entity.Order;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.ProductService;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private ProductService productService; // injected via XML
    private final Map<Integer, Order> orderMap = new HashMap<>();

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void placeOrder(Order order) {
        if (productService.getProductById(order.getProduct().getId()) != null) {
            orderMap.put(order.getOrderId(), order);
            System.out.println("Order placed: " + order);
        } else {
            System.out.println("Order failed: Product not found!");
        }
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderMap.get(orderId);
    }
}
