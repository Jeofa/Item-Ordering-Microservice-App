package com.javamicroservice.dto;

import java.math.BigDecimal;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductRequest {

	private String name;
	private String description;
	private Double price;

	
}

