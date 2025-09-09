package com.ecommerce.service;

import com.ecommerce.entity.Payment;

public interface PaymentService {
    void processPayment(Payment payment);
    Payment getPaymentDetails(int paymentId);
}
