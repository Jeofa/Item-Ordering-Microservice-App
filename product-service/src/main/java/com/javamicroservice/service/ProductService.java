package com.javamicroservice.service;


import java.util.List;

import com.javamicroservice.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javamicroservice.dto.ProductRequest;
import com.javamicroservice.dto.ProductResponse;
import com.javamicroservice.model.Product;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productrepo;
	
	public void createProduct(ProductRequest productRequest) {
		
		//map product request to product model
		Product product = new Product();
		product.setDescription(productRequest.getDescription());
		product.setName(productRequest.getName());
		product.setPrice(productRequest.getPrice());
		
		productrepo.save(product);
		
		 Logger logger = LoggerFactory.getLogger(ProductService.class);
		 
		 logger.info("Product {} is saved ",product.getId());
//		System.out.println("Product "+ product.getId()+" is saved");
		
		
	}

	public List<ProductResponse> getAllProducts() {
		
		List<Product> products = productrepo.findAll();
		Logger log = LoggerFactory.getLogger(products.toString());
		//map products to productresponse class
		return products.stream().map(this::mapToProductResponse).toList();
		
	}
	
	public ProductResponse mapToProductResponse(Product product) {
		
		ProductResponse productResponse = new ProductResponse();
		productResponse.setName(product.getName());
		productResponse.setDescription(product.getDescription());
		productResponse.setPrice(product.getPrice());
		return productResponse;
	}

}
