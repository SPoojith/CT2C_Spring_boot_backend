package com.tns.placment_management_system.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class College {
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CollegeId")
	private Long Id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="collegeId",referencedColumnName="UserId")   // it is like add new fiel named as collegeid which acts as user id
	private User collegeAdmin;
	
	private String collegeName;
	private String location;
	
	@OneToMany(mappedBy = "college")
	private List<Certificate> certificate;
	
	@OneToMany(mappedBy ="college")
	private List<Placement> placement;
	
	@OneToMany(mappedBy="college")
	private List<Student> student;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public User getCollegeAdmin() {
		return collegeAdmin;
	}
	public void setCollegeAdmin(User collegeAdmin) {
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
