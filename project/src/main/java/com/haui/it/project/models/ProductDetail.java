/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Mar 25, 2022 
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties({ "hibernateLazyInitializer" })
@Entity
@Table(name = "PRODUCTDETAIL")
public class ProductDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "size")
	private float size;
	@Column(name = "color")
	private String color;
	@Column(name = "quanity")
	private Integer quanity;
	@Column(name = "photo")
	private String photo;
	@Column(name = "originalPrice")
	private BigDecimal originalprice;
	@Column(name = "sellingPrice")
	private BigDecimal sellingPrice;

	@ManyToOne
	// @JsonDeserialize
	@JoinColumn(name = "productId", referencedColumnName = "id")
	private Product productP;

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getQuanity() {
		return quanity;
	}

	public void setQuanity(Integer integer) {
		this.quanity = integer;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public BigDecimal getOriginalprice() {
		return originalprice;
	}

	public void setOriginalprice(BigDecimal originalprice) {
		this.originalprice = originalprice;
	}

	public Long getId() {
		return id;
	}

	public Product getProductP() {
		return productP;
	}

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProductP(Product productP) {
		this.productP = productP;
	}

}
