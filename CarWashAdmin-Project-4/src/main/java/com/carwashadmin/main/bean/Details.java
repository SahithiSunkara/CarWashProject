package com.carwashadmin.main.bean;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "details")
public class Details {
	
	
	@MongoId(value = FieldType.OBJECT_ID)
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Indexed(unique = true)
	private String firstName;
	private String middleName;
	private String lastName;
	@Indexed(unique = true)
	private String email;
	@Indexed(unique = true)
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

	public Details(String id, String firstName, String middleName, String lastName, String email, String role,
			Integer phone_no, String address, String password, byte[] image) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.phone_no = phone_no;
		this.address = address;
		this.password = password;
		this.image = image;
	}
	public Details() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Details [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", email=" + email + ", role=" + role + ", phone_no=" + phone_no + ", address=" + address
				+ ", password=" + password + ", image=" + image + "]";
	}

	private Integer phone_no;
	private String address;
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

	private String password;
	private byte[] image;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(Integer phone_no) {
		this.phone_no = phone_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
