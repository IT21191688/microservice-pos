package com.shop.orderserviceapi.repo;

import com.shop.orderserviceapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order,Long> {
}
