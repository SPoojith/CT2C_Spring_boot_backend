package com.tns.placment_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tns.placment_management_system.model.Admin;


@Repository
public interface AdminRepo extends JpaRepository<Admin,Long>{

}
