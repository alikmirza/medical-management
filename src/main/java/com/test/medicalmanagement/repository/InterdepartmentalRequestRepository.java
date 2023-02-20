package com.test.medicalmanagement.repository;

import com.test.medicalmanagement.entity.InterdepartmentalRequestEntity;
import com.test.medicalmanagement.entity.MedicalManagementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterdepartmentalRequestRepository extends JpaRepository<InterdepartmentalRequestEntity, Long> {
    List<InterdepartmentalRequestEntity> findAllByMedicalManagement(MedicalManagementEntity medicalManagement);
}
