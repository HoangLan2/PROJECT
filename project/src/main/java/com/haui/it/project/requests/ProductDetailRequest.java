/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 6, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.requests;

import java.math.BigDecimal;

public class ProductDetailRequest {

	private String color;
	private String photo;
	private Integer quanity;
	private float size;
	private BigDecimal original_price;
	private BigDecimal selling_price;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getQuanity() {
		return quanity;
	}

	public void setQuanity(Integer quanity) {
		this.quanity = quanity;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public BigDecimal getOriginal_price() {
		return original_price;
	}

	public void setOriginal_price(BigDecimal original_price) {
		this.original_price = original_price;
	}

	public BigDecimal getSelling_price() {
		return selling_price;
	}

	public void setSelling_price(BigDecimal selling_price) {
		this.selling_price = selling_price;
	}

}
