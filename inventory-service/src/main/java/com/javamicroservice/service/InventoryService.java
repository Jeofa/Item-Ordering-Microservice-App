package com.javamicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javamicroservice.dto.InventoryResponse;
import com.javamicroservice.repository.InventoryRepository;

@Service
public class InventoryService {
	
	private InventoryRepository inventoryRepository;
	
	public InventoryService (InventoryRepository inventoryRepository) {
		this.inventoryRepository = inventoryRepository;
	}
	
	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> skuCode) {
		
		return inventoryRepository.findBySkuCodeIn(skuCode).stream()
				.map(inventory -> 
					InventoryResponse.builder()
						.skuCode(inventory.getSkuCode())
						.isInStock(inventory.getQuantity() > 0)
						.build()
				).toList();
		
	}

}
