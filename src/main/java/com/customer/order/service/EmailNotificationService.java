package com.customer.order.service;

import com.customer.order.common.NotificationException;
import com.customer.order.data.Customer;
import com.customer.order.data.CustomerOrder;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailNotificationService implements NotificationServiceInterface {

    private static final Logger logger = LoggerFactory.getLogger(EmailNotificationService.class);

    private final JavaMailSender mailSender;

    public EmailNotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendNotification(Customer customer, CustomerOrder customerOrder) throws NotificationException {

        logger.info("Email will be sent to the customer "+customer.getFullName());

        String subject = "Order Status Update: #" + customerOrder.getId();
        String body = "Dear " + customer.getFullName() + ",\n\n"
                + "The status of your order #" + customerOrder.getId() + " has been updated to: " + customerOrder.getOrderStatus() + ".\n\n"
                + "Thank you for your business!";

        logger.info(subject);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(customer.getEmail());
            helper.setSubject(subject);
            helper.setText(body);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new NotificationException("Error creating email message", e);
        }

        mailSender.send(message);
    }

}
