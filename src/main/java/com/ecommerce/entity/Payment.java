package com.ecommerce.entity;

public class Payment {
    private int paymentId;
    private Order order;
    private String status;

    public Payment() {}

    public Payment(int paymentId, Order order, String status) {
        this.paymentId = paymentId;
        this.order = order;
        this.status = status;
    }

    public int getPaymentId() { return paymentId; }
    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Payment { " +
                "paymentId=" + paymentId +
                ", order=" + order +
                ", status='" + status + '\'' +
                " }";
    }
}
