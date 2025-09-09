package com.ecommerce;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.Payment;
import com.ecommerce.entity.Product;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.PaymentService;
import com.ecommerce.service.ProductService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("com/ecommerce/config/beans.xml");

        ProductService productService = (ProductService) context.getBean("productService");
        OrderService orderService = (OrderService) context.getBean("orderService");
        PaymentService paymentService = (PaymentService) context.getBean("paymentService");


        Product p1 = new Product(1, "Laptop", 75000);
        Product p2 = new Product(2, "Smartphone", 30000);
        productService.addProduct(p1);
        productService.addProduct(p2);

        Order order = new Order(101, p1, 2);
        orderService.placeOrder(order);

        Payment payment = new Payment(1001, order, "PENDING");
        paymentService.processPayment(payment);

        System.out.println("Fetched Product: " + productService.getProductById(1));
        System.out.println("Fetched Order: " + orderService.getOrderById(101));
        System.out.println("Fetched Payment: " + paymentService.getPaymentDetails(1001));

        context.close();
    }
}
