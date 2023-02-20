package com.test.medicalmanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MedicalManagementRequestDto {
    private LocalDateTime documentExpiryDate;
}
