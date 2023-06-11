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
			e.setTitle("Java Developer");

			employeesRepository.save(e);

			Employee e2 = new Employee();
			e2.setName("Márcio");
			e2.setLastName("Rodrigo");
			e2.setDepartment("Desenvolvimento de Softwares");
			e2.setTitle("Java Developer");

			employeesRepository.save(e2);

			Employee e3 = new Employee();
			e3.setName("Cristiano");
			e3.setLastName("Ronaldo");
			e3.setDepartment("Desenvolvimento de Softwares");
			e3.setTitle("React Developer");

			employeesRepository.save(e3);
		};

	}

}
