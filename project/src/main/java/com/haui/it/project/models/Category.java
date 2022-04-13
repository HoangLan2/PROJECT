/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Mar 25, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "CATEGORIES")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> productsC = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public List<Product> getProductsC() {
		return productsC;
	}

	public void setProductsC(List<Product> productsC) {
		this.productsC = productsC;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
