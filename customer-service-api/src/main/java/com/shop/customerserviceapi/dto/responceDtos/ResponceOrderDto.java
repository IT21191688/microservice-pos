package com.shop.customerserviceapi.dto.responceDtos;

import com.shop.customerserviceapi.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponceOrderDto {

    List<OrderDto> list;
}
