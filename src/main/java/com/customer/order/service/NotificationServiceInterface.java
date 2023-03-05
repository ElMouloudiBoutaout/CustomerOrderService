package com.customer.order.service;

import com.customer.order.data.Customer;
import com.customer.order.data.CustomerOrder;

public interface NotificationServiceInterface {
    public void sendNotification(Customer customer, CustomerOrder customerOrder);
}
