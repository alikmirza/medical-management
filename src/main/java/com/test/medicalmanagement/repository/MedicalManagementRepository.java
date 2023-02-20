package com.test.medicalmanagement.repository;

import com.test.medicalmanagement.entity.MedicalManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalManagementRepository extends JpaRepository<MedicalManagementEntity, Long> {
}
