package com.customer.order.common;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Order with ID " + id + " not found.");
    }
}