package com.javamicroservice;

import com.javamicroservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.javamicroservice.model.Inventory;
import com.javamicroservice.repository.InventoryRepository;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inv = new Inventory();
			inv.setQuantity(23);
			inv.setSkuCode("itel");

			Inventory invt = new Inventory();
			invt.setQuantity(0);
			invt.setSkuCode("oppo");

			inventoryRepository.save(inv);
			inventoryRepository.save(invt);
		};
	}

}
