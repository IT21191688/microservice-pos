package com.shop.customerserviceapi.utill.responce;

import com.shop.customerserviceapi.dto.OrderDto;
import com.shop.customerserviceapi.dto.responceDtos.ResponceOrderDto;
import com.shop.customerserviceapi.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomCustomerResponce {
    private Customer customer;
    private List<OrderDto> orders;

}