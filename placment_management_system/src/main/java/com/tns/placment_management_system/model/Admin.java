package com.tns.placment_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler"})
@Entity
public class Admin {
	@Id
	@Column(name="AdminId")
	private long id;
	
	private String name;
	private String password;
	
	@OneToOne(fetch=FetchType.LAZY)
	@MapsId
	@JoinColumn(name="AdminId")
	private User user;   //method 2(1-1) ie where the admin id will be both primary key for admin and foreign key for user table 
	
	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="UserId",referencedColumnName="UserId")
	private User user;*/ //method 1(1-1) ie u will have an extra field as user_id which is foreign key of user table;
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
