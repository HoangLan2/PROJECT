/*
 *   @author:  Nguyen Hoang Lan 
 *   @date:    Apr 7, 2022 
 *   @version: 1.0 
*/
package com.haui.it.project.requests;

public class UserRequest {

	private String name;
	private String address;
	private String email;
	private String password;
	private String photo;
	private String role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
