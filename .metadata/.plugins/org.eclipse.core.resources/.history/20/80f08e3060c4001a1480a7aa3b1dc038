package com.carwashadmin.main.bean;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Images")
public class Images {
	@Id
	private String id;
	private String name;
	private String type;
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Images [id=" + id + ", name=" + name + ", type=" + type + ", picbyte=" + Arrays.toString(picbyte) + "]";
	}
	public Images(String name, String type, byte[] picbyte) {
		super();
		this.name = name;
		this.type = type;
		this.picbyte = picbyte;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public byte[] getPicbyte() {
		return picbyte;
	}
	public void setPicbyte(byte[] picbyte) {
		this.picbyte = picbyte;
	}
	private byte[] picbyte;
	
}
