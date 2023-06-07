package com.mrodrigochaves.employees;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mrodrigochaves.employees.model.Employees;
import com.mrodrigochaves.employees.repository.EmployeesRepository;

@SpringBootApplication
public class EmployeesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}


	@Bean
	CommandLineRunner initDataBase(EmployeesRepository employeesRepository){
		return args ->{
			employeesRepository.deleteAll();
			
			Employees e = new Employees();
			e.setName("José");
			e.setLastname("Mourinho");
			e.setDepartament("Desenvolvimento de Softwares");
			e.setTitle("Senior Java Developer");

			employeesRepository.save(e);
		};

	}


}
