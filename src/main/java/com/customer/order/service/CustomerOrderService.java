package com.customer.order.service;

import com.customer.order.common.InvalidOrderStatusException;
import com.customer.order.common.OrderNotFoundException;
import com.customer.order.data.CustomerOrder;
import com.customer.order.data.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService implements CustomerOrderServiceInterface {

    private static final Logger logger = LoggerFactory.getLogger(CustomerOrderService.class);

    private final CustomerOrderRepository customerOrderRepository;

    private final CustomerRepository customerRepository;

    private final NotificationServiceInterface notificationService;

    @Autowired
    public CustomerOrderService(CustomerOrderRepository customerOrderRepository, CustomerRepository customerRepository, NotificationServiceInterface notificationService) {
        this.customerOrderRepository = customerOrderRepository;
        this.customerRepository = customerRepository;
        this.notificationService = notificationService;
    }

    public List<CustomerOrder> getAllOrders() {
        return customerOrderRepository.findAll();
    }

    public CustomerOrder getOrderById(Long id) {
        return customerOrderRepository.findById(id).orElse(null);
    }

    public CustomerOrder createOrder(CustomerOrder customerOrder) {
        customerOrder.setOrderStatus(OrderStatus.PLACED);
        return customerOrderRepository.save(customerOrder);
    }

    public CustomerOrder updateOrderStatus(Long id, String newStatus) {

        logger.info("Order "+id+" being updated to "+newStatus);

        CustomerOrder customerOrder = customerOrderRepository.findById(id).orElseThrow((() -> new OrderNotFoundException(id)));
        try{
            customerOrder.setOrderStatus(OrderStatus.valueOf(newStatus.toUpperCase()));
        }catch (IllegalArgumentException e){
            throw new InvalidOrderStatusException(newStatus);
        }
        notificationService.sendNotification(customerOrder.getCustomer(),customerOrder);
        return customerOrderRepository.save(customerOrder);
    }
}
