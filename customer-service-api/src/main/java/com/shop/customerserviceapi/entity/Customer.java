package com.shop.customerserviceapi.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customers")
@Getter
@Setter
public class Customer {

    @Id
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="address",nullable = false)
    private String address;

    @Column(name="salary",nullable = false)
    private double salary;


}
