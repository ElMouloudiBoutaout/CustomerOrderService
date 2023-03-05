package com.customer.order.service;

import com.customer.order.data.CustomerOrder;

import java.util.List;

public interface CustomerOrderServiceInterface {
    List<CustomerOrder> getAllOrders();
    CustomerOrder getOrderById(Long id);
    CustomerOrder createOrder(CustomerOrder customerOrder);
    CustomerOrder updateOrderStatus(Long id, String newStatus);
}
