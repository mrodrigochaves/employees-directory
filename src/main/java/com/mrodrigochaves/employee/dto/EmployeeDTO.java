package com.mrodrigochaves.employee.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmployeesDTO(
    @JsonProperty("_id") Long id,
    @NotBlank @NotNull String name,
    @NotBlank @NotNull String lastname,
    @NotBlank @NotNull String departament,
    @NotBlank @NotNull String title) {
    
}
