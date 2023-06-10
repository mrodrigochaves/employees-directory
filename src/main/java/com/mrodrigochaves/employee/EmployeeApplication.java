package com.mrodrigochaves.employee;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mrodrigochaves.employee.model.Employee;
import com.mrodrigochaves.employee.repository.EmployeeRepository;


@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(EmployeeRepository employeesRepository){
		return args ->{
			employeesRepository.deleteAll();
			
			Employee e = new Employee();
			e.setName("José");
			e.setLastName("Mourinho");
			e.setDepartment("Desenvolvimento de Softwares");
			e.setTitle("Senior Java Developer");

			employeesRepository.save(e);
		};

	}

}
