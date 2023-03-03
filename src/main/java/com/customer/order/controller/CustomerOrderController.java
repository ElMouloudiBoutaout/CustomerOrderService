package com.customer.order.controller;

import com.customer.order.common.InvalidOrderStatusException;
import com.customer.order.common.OrderNotFoundException;
import com.customer.order.data.Order;
import com.customer.order.data.OrderStatus;
import com.customer.order.service.CustomerOrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class CustomerOrderController {

    private final CustomerOrderServiceInterface orderService;

    @Autowired
    public CustomerOrderController(CustomerOrderServiceInterface orderService) {
        this.orderService = orderService;
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId, @RequestBody OrderStatus newStatus) {
        try {
            Order order = orderService.updateOrderStatus(orderId, newStatus);
            return ResponseEntity.ok(order);
        } catch (OrderNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (InvalidOrderStatusException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
