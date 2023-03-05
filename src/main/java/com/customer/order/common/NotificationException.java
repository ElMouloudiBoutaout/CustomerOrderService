package com.customer.order.common;

public class NotificationException extends RuntimeException {
    public NotificationException(String message,Exception e) {
        super(message);
    }

}
