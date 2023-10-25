package com.javamicroservice.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Data
@Getter 
@Setter
@Table(name="t_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String orderNumber;
	
	@OneToMany(cascade = CascadeType.ALL )
	private List<OrderLineItems> orderLineItemsList;

	public Order(String orderNumber, List<OrderLineItems> orderLineItemsList) {
		super();
		this.orderNumber = orderNumber;
		this.orderLineItemsList = orderLineItemsList;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<OrderLineItems> getOrderLineItemsList() {
		return orderLineItemsList;
	}

	public void setOrderLineItemsList(List<OrderLineItems> orderLineItemsList) {
		this.orderLineItemsList = orderLineItemsList;
	}
	
	
	

}
