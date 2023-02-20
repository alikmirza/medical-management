package com.test.medicalmanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class InterdepartmentalRequestDto {
    private String type;
    private String name;
    private String responsible;
    private LocalDateTime createdAt;
    private Long mmId;
}
