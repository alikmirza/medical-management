package com.test.medicalmanagement.controller;

import com.test.medicalmanagement.dto.MedicalManagementRequestDto;
import com.test.medicalmanagement.service.MedicalManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/document")
@RequiredArgsConstructor
@Api(value = "Medical Management Services")
public class MedicalManagementController {
    private final MedicalManagementService service;

    @ApiOperation(value = "Service for inserting data")
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody MedicalManagementRequestDto request) {
        service.insert(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
