package com.customer.order.common;

import com.customer.order.data.OrderStatus;

public class InvalidOrderStatusException extends RuntimeException {
    public InvalidOrderStatusException(OrderStatus status) {
        super("Invalid order status: " + status);
    }
}
