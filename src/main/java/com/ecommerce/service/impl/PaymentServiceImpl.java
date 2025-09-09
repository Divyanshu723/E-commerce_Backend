package com.ecommerce.service.impl;

import com.ecommerce.entity.Payment;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.PaymentService;

import java.util.HashMap;
import java.util.Map;

public class PaymentServiceImpl implements PaymentService {

    private OrderService orderService;
    private final Map<Integer, Payment> paymentMap = new HashMap<>();

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void processPayment(Payment payment) {
        if (orderService.getOrderById(payment.getOrder().getOrderId()) != null) {
            payment.setStatus("SUCCESS");
            paymentMap.put(payment.getPaymentId(), payment);
            System.out.println("Payment processed: " + payment);
        } else {
            payment.setStatus("FAILED - Order not found");
            System.out.println("Payment failed: " + payment);
        }
    }

    @Override
    public Payment getPaymentDetails(int paymentId) {
        return paymentMap.get(paymentId);
    }
}
