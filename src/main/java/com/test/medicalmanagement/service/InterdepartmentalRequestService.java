package com.test.medicalmanagement.service;

import com.test.medicalmanagement.dto.InterdepartmentalRequestDto;
import com.test.medicalmanagement.entity.MedicalManagementEntity;

public interface InterdepartmentalRequestService {
    void insert(InterdepartmentalRequestDto requestDto);
    long count(Long id);
    MedicalManagementEntity medicalManagementEntityById(Long id);
}
