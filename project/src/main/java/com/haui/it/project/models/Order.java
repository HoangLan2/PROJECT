/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Mar 25, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @JsonDeserialize
	private Long id;

	@Column(name = "createDate")
	private Date createDate;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;

	@JsonIgnore
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails = new ArrayList<>();

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
