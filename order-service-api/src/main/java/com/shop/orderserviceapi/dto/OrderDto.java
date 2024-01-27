package com.shop.orderserviceapi.dto;

import com.shop.orderserviceapi.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private String orderId;
    private String customerId;
    private List<Long> productIds;
    private Double cost;

    public static OrderDto fromOrder(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getOrderId().toString());
        orderDto.setCustomerId(order.getCustomerId().toString());
        orderDto.setProductIds(order.getProductIds());
        orderDto.setCost(order.getCost());
        return orderDto;
    }

}
