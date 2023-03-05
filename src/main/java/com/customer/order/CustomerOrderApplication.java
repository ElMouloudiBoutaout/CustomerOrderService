package com.customer.order;

import com.customer.order.data.Customer;
import com.customer.order.data.CustomerOrder;
import com.customer.order.service.CustomerOrderRepository;
import com.customer.order.service.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CustomerOrderApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CustomerOrderApplication.class, args);
	}

	@Autowired
	private CustomerOrderRepository customerOrderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {

		customerRepository.saveAll(Arrays.asList(
				new Customer("Customer 01","boutaoutelmouloudi@gmail.com"),
				new Customer("Customer 02","email2@gmail.com"),
				new Customer("Customer 03","email3@gmail.com")));

		Customer customer01 = customerRepository.findByFullName("Customer 01");

		customerOrderRepository.saveAll(Arrays.asList(
				new CustomerOrder(customer01),
				new CustomerOrder(customer01),
				new CustomerOrder(customer01)));
	}
}
