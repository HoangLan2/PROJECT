/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Mar 25, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "metal")
	private String metal;

	@ManyToOne
	@JoinColumn(name = "categoryId", referencedColumnName = "id")
	private Category category;

	@JsonIgnore
	@OneToMany(mappedBy = "productP")
	private List<ProductDetail> productDetail = new ArrayList<>();

	@JsonIgnore
	// @JsonDeserialize
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMetal() {
		return metal;
	}

	public void setMetal(String metal) {
		this.metal = metal;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ProductDetail> getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(List<ProductDetail> productDetail) {
		this.productDetail = productDetail;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
