package com.shop.orderserviceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private Long customerId;
    private List<Long> productIds;
    private Double cost;
}
