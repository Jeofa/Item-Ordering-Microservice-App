package com.javamicroservice;

import com.javamicroservice.model.Product;
import com.javamicroservice.repository.ProductRepository;
import com.javamicroservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceApplicationTests {

	@MockBean
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@Test
	void contextLoads() {
	}

	public void getAllProductsTests(){
		when(productRepository.findAll()).thenReturn(
				Stream.of(new Product(1,"Dell","Refurb",234.0), new Product(2,"HP","new",746.9)).collect(Collectors.toList()));
		assertEquals(2,productService.getAllProducts().size());
	}

}
