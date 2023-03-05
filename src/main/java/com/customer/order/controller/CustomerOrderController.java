package com.customer.order.controller;

import com.customer.order.common.OrderStatusDto;
import com.customer.order.data.CustomerOrder;
import com.customer.order.service.CustomerOrderServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class CustomerOrderController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerOrderController.class);

    private final CustomerOrderServiceInterface orderService;

    @Autowired
    public CustomerOrderController(CustomerOrderServiceInterface orderService) {
        this.orderService = orderService;
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<CustomerOrder> updateOrderStatus(@PathVariable Long orderId, @RequestBody OrderStatusDto newStatus) {
            logger.info("Order status update is being invoked ");
            CustomerOrder customerOrder = orderService.updateOrderStatus(orderId, newStatus.orderStatus);
            return ResponseEntity.ok(customerOrder);
    }

}
