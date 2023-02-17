package com.tns.placment_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.placment_management_system.model.Certificate;

public interface CertificateRepo extends JpaRepository<Certificate,Long> {

}
