package com.customer.order.service;

import com.customer.order.data.Order;
import com.customer.order.data.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService implements CustomerOrderServiceInterface {
    private final OrderRepository orderRepository;

    public CustomerOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(Order order) {
        order.setOrderStatus(OrderStatus.PLACED);
        return orderRepository.save(order);
    }

    public Order updateOrderStatus(Long id, OrderStatus newStatus) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return null;
        }
        order.setOrderStatus(newStatus);
        return orderRepository.save(order);
    }
}
