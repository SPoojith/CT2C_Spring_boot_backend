package com.tns.placment_management_system.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name="Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="StudentId")
	private Long id;
	
	private String name;
	
	@ManyToOne
	private College college;
	private String qualification;
	private String course;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="StudentId",referencedColumnName="CertificateId")
	private Certificate certificate;	
	
	private Integer year;
	private Long roll;
	private Long hallTicketNo;
	
	public Student() {}
	
	public Student(Long id, String name, College college, String qualification, String course, Certificate certificate,
			Integer year, Long roll, Long hallTicketNo) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.qualification = qualification;
		this.course = course;
		this.certificate = certificate;
		this.year = year;
		this.roll = roll;
		this.hallTicketNo = hallTicketNo;
	}
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + ", qualification=" + qualification
				+ ", course=" + course + ", certificate=" + certificate + ", year=" + year + ", roll=" + roll
				+ ", hallTicketNo=" + hallTicketNo + "]";
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

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Long getRoll() {
		return roll;
	}

	public void setRoll(Long roll) {
		this.roll = roll;
	}
	public Long getHallTicketNo() {
		return hallTicketNo;
	}

	public void setHallTicketNo(Long hallTicketNo) {
		this.hallTicketNo = hallTicketNo;
	}
	

}
