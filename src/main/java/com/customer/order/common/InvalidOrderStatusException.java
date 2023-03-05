package com.customer.order.common;

public class InvalidOrderStatusException extends RuntimeException {
    public InvalidOrderStatusException(String status) {
        super("Invalid order status: " + status);
    }
}
