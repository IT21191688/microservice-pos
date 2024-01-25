package com.shop.customerserviceapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {

    private String name;
    private String address;
    private Double salary;

}
