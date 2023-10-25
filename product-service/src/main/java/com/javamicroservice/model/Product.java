package com.javamicroservice.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)	
	private int id;
	
	private String name;
	private String description;
	private Double price;


	
}
