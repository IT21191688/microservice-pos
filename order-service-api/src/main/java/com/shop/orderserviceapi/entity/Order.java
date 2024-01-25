package com.shop.orderserviceapi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    private Long orderId;

    @Column(name="customerId")
    private Long customerId;

    @ElementCollection
    @CollectionTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "product_id")
    private List<Long> productIds;

    @Column(name="cost")
    private Double cost;



}
