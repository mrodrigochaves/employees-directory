package com.mrodrigochaves.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrodrigochaves.employee.dto.EmployeeDTO;
import com.mrodrigochaves.employee.model.Employee;
import com.mrodrigochaves.employee.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<EmployeeDTO> create(EmployeeDTO request) {
        Employee employee = mapper.map(request, Employee.class);
        employee = repository.save(employee);
        return Optional.ofNullable(mapper.map(employee, EmployeeDTO.class));
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<Employee> employee = repository.findAll();
        List<EmployeeDTO> responses = new ArrayList<>();
        employee.forEach(employees -> {
            EmployeeDTO response = mapper.map(employees, EmployeeDTO.class);
            responses.add(response);
        });
        return responses;
    }

    @Override
    public Optional<EmployeeDTO> getById(Long id) {
        Optional<Employee> employee = repository.findById(id);
        return employee.map(e -> mapper.map(e, EmployeeDTO.class));
    }

    @Override
    public Optional<EmployeeDTO> update(Long id, EmployeeDTO request) {
        Optional<Employee> employees = repository.findById(id);
        if (employees.isPresent()) {
            Employee employee = employee.getId();
            employee.setDepartment(request.departament());
            employee.setTitle(request.title());
            repository.save(employee);
            return Optional.of(mapper.map(employee, EmployeeDTO.class));
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
    public List<EmployeeDTO> getByLastName(String name) {
        List<Employee> employees = repository.findByLastName(name);
        List<EmployeeDTO> responses = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeDTO response = mapper.map(employee, EmployeeDTO.class);
            responses.add(response);
        });
        return responses;
    }

    @Override
    public List<EmployeeDTO> getByDepartament(String name) {
        List<Employee> employees = repository.findByDepartment(name);
        List<EmployeeDTO> responses = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeDTO response = mapper.map(employee, EmployeeDTO.class);
            responses.add(response);
        });
        return responses;
    }

    @Override
    public List<EmployeeDTO> getByTitle(String name) {
        List<Employee> employees = repository.findByTitle(name);
        List<EmployeeDTO> responses = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeeDTO response = mapper.map(employee, EmployeeDTO.class);
            responses.add(response);
        });
        return responses;
    }
}
