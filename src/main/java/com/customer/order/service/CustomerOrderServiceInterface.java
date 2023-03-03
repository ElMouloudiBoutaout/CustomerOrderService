package com.customer.order.service;

import com.customer.order.data.Order;
import com.customer.order.data.OrderStatus;

import java.util.List;

public interface CustomerOrderServiceInterface {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(Order order);
    Order updateOrderStatus(Long id, OrderStatus newStatus);
}
