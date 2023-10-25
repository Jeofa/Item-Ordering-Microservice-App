package com.javamicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javamicroservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
