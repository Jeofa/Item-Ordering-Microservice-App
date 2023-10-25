package com.javamicroservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.javamicroservice.dto.InventoryResponse;
import com.javamicroservice.dto.OrderLineItemsDto;
import com.javamicroservice.dto.OrderRequest;
import com.javamicroservice.model.Order;
import com.javamicroservice.model.OrderLineItems;
import com.javamicroservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	private final WebClient webClient;
	
	public void placeOrder(OrderRequest orderRequest) {
		
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		//map orderrequest to orderlineitems
		
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDto().stream().map(this::mapToDto).toList();
		
		order.setOrderLineItemsList(orderLineItems);
		
		System.out.println("order recieved phase 1");
		
		//get skucode for the order list store all in the a list
		List<String> skuCodes = order.getOrderLineItemsList().stream().map(OrderLineItems -> OrderLineItems.getSkuCode()).toList();
		
		//display list of the skucodes
		System.out.println("SkuCodes:: "+skuCodes);
		
		//call inventory service check if is in stock
		InventoryResponse[]	inventoryResponseArray = webClient.get()
				.uri("http://localhost:8082/api/inventory",
						uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
				.retrieve()
				.bodyToMono(InventoryResponse[].class)
				.block();

		System.out.println("data sent to inventory service" +  Arrays.toString(inventoryResponseArray));
		
		Boolean allProductsInStock = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);
		System.out.println("Are all items in stock? "+allProductsInStock);
		if(allProductsInStock) {
			orderRepository.save(order);
		}else {
			throw new IllegalArgumentException("Product not found please try again later");
		}
		
		
	}

	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
		
		return orderLineItems;
	}
	

}
