package com.mrodrigochaves.employees.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mrodrigochaves.employees.dto.EmployeesDTO;
import com.mrodrigochaves.employees.service.EmployeesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeesService service;
    
    @PostMapping
    public ResponseEntity<EmployeesDTO> create(@RequestBody @Valid EmployeesDTO request){
        Optional<EmployeesDTO> response = service.create(request);
        if( response.isPresent()){
            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);   
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
