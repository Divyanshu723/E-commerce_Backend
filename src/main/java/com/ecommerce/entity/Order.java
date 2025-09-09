package com.ecommerce.entity;

public class Order {
    private int orderId;
    private Product product;
    private int quantity;

    public Order() {}

    public Order(int orderId, Product product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "Order { " +
                "orderId=" + orderId +
                ", product=" + product +
                ", quantity=" + quantity +
                " }";
    }
}
