package com.javamicroservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class InventoryServiceApplicationTests {

	@MockBean
	private InvertoryRepository invertoryRepository;

	@Autwired
	private InventoryService inventoryService;

	@Test
	void contextLoads() {
	}

	public void getIsInStockTests(){
		when(invertoryRepository.findAll()).thenReturn(
				Stream.of(new Product(1,"Dell","Refurb",234.0), new Product(2,"HP","new",746.9)).collect(Collectors.toList()));
		assertEquals(2,productService.getAllProducts().size());
	}

}
