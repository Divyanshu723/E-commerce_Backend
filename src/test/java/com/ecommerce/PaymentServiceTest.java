package com.ecommerce;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.Payment;
import com.ecommerce.entity.Product;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.PaymentService;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.impl.OrderServiceImpl;
import com.ecommerce.service.impl.PaymentServiceImpl;
import com.ecommerce.service.impl.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentServiceTest {

    private PaymentService paymentService;
    private OrderService orderService;
    private ProductService productService;

    @Before
    public void setUp() {
        productService = new ProductServiceImpl();

        OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
        orderServiceImpl.setProductService(productService);
        orderService = orderServiceImpl;

        PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
        paymentServiceImpl.setOrderService(orderService);
        paymentService = paymentServiceImpl;

        productService.addProduct(new Product(1, "Laptop", 75000));
        orderService.placeOrder(new Order(101, productService.getProductById(1), 1));
    }

    @Test
    public void testProcessPaymentSuccess() {
        Order order = orderService.getOrderById(101);
        Payment payment = new Payment(1001, order, "PENDING");

        paymentService.processPayment(payment);

        Payment fetched = paymentService.getPaymentDetails(1001);
        assertEquals("SUCCESS", fetched.getStatus());
    }

    @Test
    public void testProcessPaymentFailure() {
        Order fakeOrder = new Order(999, new Product(99, "Fake", 0), 1);
        Payment payment = new Payment(1002, fakeOrder, "PENDING");

        paymentService.processPayment(payment);

        Payment fetched = paymentService.getPaymentDetails(1002);
        assertNull(fetched); // Payment should not be saved
    }
}
