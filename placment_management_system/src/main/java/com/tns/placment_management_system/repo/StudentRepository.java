package com.tns.placment_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tns.placment_management_system.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	
	@Query("SELECT id from Student where hallTicketNo = ?1")
	public Long searchStudentByHallticket(Long hallticket);
	
	
	

}
