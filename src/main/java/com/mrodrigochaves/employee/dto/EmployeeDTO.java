package com.mrodrigochaves.employee.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    private String department;

    @NotBlank
    private String title;

}
