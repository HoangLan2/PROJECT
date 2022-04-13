/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Mar 30, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "ORDERDETAIL")
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	@ManyToOne
	// @JsonDeserialize
	@JoinColumn(name = "orderId")
	private Order order;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "totalPrice")
	private BigDecimal totalPrice;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer integer) {
		this.quantity = integer;
	}

	public Long getId() {
		return id;
	}

	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
