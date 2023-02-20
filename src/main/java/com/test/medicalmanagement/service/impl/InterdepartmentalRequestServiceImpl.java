package com.test.medicalmanagement.service.impl;

import com.test.medicalmanagement.dto.InterdepartmentalRequestDto;
import com.test.medicalmanagement.entity.InterdepartmentalRequestEntity;
import com.test.medicalmanagement.entity.MedicalManagementEntity;
import com.test.medicalmanagement.exception.CommonAPIException;
import com.test.medicalmanagement.repository.InterdepartmentalRequestRepository;
import com.test.medicalmanagement.repository.MedicalManagementRepository;
import com.test.medicalmanagement.service.InterdepartmentalRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class InterdepartmentalRequestServiceImpl implements InterdepartmentalRequestService {
    private final InterdepartmentalRequestRepository interdepartmentalRequestRepository;
    private final MedicalManagementRepository medicalManagementRepository;

    @Override
    public void insert(InterdepartmentalRequestDto requestDto) {
        interdepartmentalRequestRepository.save(
                InterdepartmentalRequestEntity.builder()
                        .name(requestDto.getName())
                        .type(requestDto.getType())
                        .responsible(requestDto.getResponsible())
                        .createdAt(LocalDateTime.now())
                        .medicalManagement(
                                medicalManagementEntityById(requestDto.getMmId())
                        )
                        .build()
        );
    }

    @Override
    public long count(Long id) {
        return interdepartmentalRequestRepository.findAllByMedicalManagement(
                medicalManagementEntityById(id)
        ).size();
    }

    @Override
    public MedicalManagementEntity medicalManagementEntityById(Long id) {
        return medicalManagementRepository.findById(id)
                .orElseThrow(() -> new CommonAPIException(HttpStatus.NOT_FOUND, String.format("Data with %d id does not exists", id)));
    }
}
