package com.test.medicalmanagement.service.impl;

import com.test.medicalmanagement.dto.MedicalManagementRequestDto;
import com.test.medicalmanagement.entity.MedicalManagementEntity;
import com.test.medicalmanagement.repository.MedicalManagementRepository;
import com.test.medicalmanagement.service.MedicalManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalManagementServiceImpl implements MedicalManagementService {
    private final MedicalManagementRepository repository;

    @Override
    public void insert(MedicalManagementRequestDto request) {
        repository.save(
                MedicalManagementEntity.builder()
                        .documentExpiryDate(request.getDocumentExpiryDate())
                        .build()
        );
    }
}
