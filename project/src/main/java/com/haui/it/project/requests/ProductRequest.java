/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 5, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.requests;

import java.util.List;

public class ProductRequest {

	private Long categoryId;
	private String metal;
	private String name;

	private List<ProductDetailRequest> proDetails;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getMetal() {
		return metal;
	}

	public void setMetal(String metal) {
		this.metal = metal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductDetailRequest> getProDetails() {
		return proDetails;
	}

	public void setProDetails(List<ProductDetailRequest> proDetails) {
		this.proDetails = proDetails;
	}

}
