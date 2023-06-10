package com.mrodrigochaves.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrodrigochaves.employee.dto.EmployeesDTO;
import com.mrodrigochaves.employee.model.Employee;
import com.mrodrigochaves.employee.repository.EmployeeRepository;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    private final EmployeeRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public EmployeesServiceImpl(EmployeeRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<EmployeesDTO> create(EmployeesDTO request) {
        Employee employee = mapper.map(request, Employee.class);
        employee = repository.save(employee);
        return Optional.ofNullable(mapper.map(employee, EmployeesDTO.class));
    }

    @Override
    public List<EmployeesDTO> getAll() {
        List<Employee> employee = repository.findAll();
        List<EmployeesDTO> responses = new ArrayList<>();
        employee.forEach(employees -> {
            EmployeesDTO response = mapper.map(employees, EmployeesDTO.class);
            responses.add(response);
        });
        return responses;
    }

    @Override
    public Optional<EmployeesDTO> getById(Long id) {
        Optional<Employee> employee = repository.findById(id);
        return employee.map(e -> mapper.map(e, EmployeeDTO.class));
    }

    @Override
    public Optional<EmployeeDTO> update(Long id, EmployeeDTO request) {
        Optional<Employee> employees = repository.findById(id);
        if (employee.isPresent()) {
            Employee employee = employee.get();
            employee.setDepartament(request.departament());
            employee.setTitle(request.title());
            repository.save(employee);
            return Optional.of(mapper.map(employee, EmployeesDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<EmployeesDTO> getByLastName(String name) {
        List<Employees> employees = repository.findByLastName(name);
        List<EmployeesDTO> responses = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeesDTO response = mapper.map(employee, EmployeesDTO.class);
            responses.add(response);
        });
        return responses;
    }

    @Override
    public List<EmployeesDTO> getByDepartament(String name) {
        List<Employees> employees = repository.findByDepartament(name);
        List<EmployeesDTO> responses = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeesDTO response = mapper.map(employee, EmployeesDTO.class);
            responses.add(response);
        });
        return responses;
    }

    @Override
    public List<EmployeesDTO> getByTitle(String name) {
        List<Employees> employees = repository.findByTitle(name);
        List<EmployeesDTO> responses = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeesDTO response = mapper.map(employee, EmployeesDTO.class);
            responses.add(response);
        });
        return responses;
    }
}
