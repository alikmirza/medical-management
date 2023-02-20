package com.test.medicalmanagement.controller;

import com.test.medicalmanagement.dto.InterdepartmentalRequestDto;
import com.test.medicalmanagement.service.InterdepartmentalRequestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/interdepartmental-request")
@RequiredArgsConstructor
@Api(value = "Interdepartmental Services")
public class InterdepartmentalRequestController {
    private final InterdepartmentalRequestService service;

    @ApiOperation(value = "Service for inserting data")
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody InterdepartmentalRequestDto request) {
        service.insert(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Service for getting count of interdepartmental requests")
    @GetMapping("/count/{id}")
    public ResponseEntity<?> getCount(@PathVariable Long id) {
        return ResponseEntity.ok(service.count(id));
    }
}
