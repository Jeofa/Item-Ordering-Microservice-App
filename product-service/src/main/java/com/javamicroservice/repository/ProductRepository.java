package com.javamicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javamicroservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
