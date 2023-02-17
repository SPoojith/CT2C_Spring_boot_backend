package com.tns.placment_management_system.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler"})
@Entity
public class College {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CollegeId")
	private Long Id;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="AdminId",referencedColumnName="AdminId")   // it is like add new fiel named as collegeid which acts as user id
	private Admin collegeAdmin;
	
	private String collegeName;
	
	private String location;
	
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Admin getCollegeAdmin() {
		return collegeAdmin;
	}
	public void setCollegeAdmin(Admin collegeAdmin) {
		this.collegeAdmin = collegeAdmin;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
