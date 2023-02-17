package com.tns.placment_management_system.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler"})
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UserId")
	private Long id;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", type=" + type + ", password=" + password + "]";
	}
	private String name; 
	private String type;
	private String password;
	
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Admin admin;
	
	/*@OneToOne
	private Admin admin;*/ //method 1(1-1)
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
