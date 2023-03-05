package com.customer.order.common;

import com.customer.order.data.OrderStatus;

public class OrderStatusDto {

    public String orderStatus;

    public OrderStatus toOrderStatus(){
        return OrderStatus.valueOf(orderStatus) ;
    }

}
