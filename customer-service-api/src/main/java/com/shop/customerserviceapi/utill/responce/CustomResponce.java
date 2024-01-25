package com.shop.customerserviceapi.utill.responce;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomResponce{

    private Object data;
    private int statusCode;
    private String message;
    private boolean successful;


}
