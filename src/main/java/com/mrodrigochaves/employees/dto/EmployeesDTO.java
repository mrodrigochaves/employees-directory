package com.mrodrigochaves.employees.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeesDTO {

    @NotNull
	@Size(min=2, max=30)
    private String name;

    @NotNull
	@Size(min=2, max=30)
    private String lastname;

    @NotNull
	@Size(min=2, max=30)
    private String departament;

    @NotNull
	@Size(min=2, max=30)
    private String title;

    
    private boolean available;
    
}
