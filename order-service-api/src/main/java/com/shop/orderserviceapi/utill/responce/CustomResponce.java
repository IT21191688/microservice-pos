package com.shop.orderserviceapi.utill.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomResponce{

    private Object data;
    private int statusCode;
    private String message;
    private boolean successful;


}
