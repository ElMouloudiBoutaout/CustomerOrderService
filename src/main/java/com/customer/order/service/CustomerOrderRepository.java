package com.customer.order.service;

import com.customer.order.data.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "orders", collectionResourceRel = "orders")
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
