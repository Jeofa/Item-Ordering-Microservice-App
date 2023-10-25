package com.javamicroservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="t_inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String skuCode;
	private int quantity;
	

	
	

}
