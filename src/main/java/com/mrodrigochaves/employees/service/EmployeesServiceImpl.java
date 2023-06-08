package com.mrodrigochaves.employees.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrodrigochaves.employees.dto.EmployeesDTO;
import com.mrodrigochaves.employees.model.Employees;
import com.mrodrigochaves.employees.repository.EmployeesRepository;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    private final EmployeesRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public EmployeesServiceImpl(EmployeesRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<EmployeesDTO> create(EmployeesDTO request) {
        Employees employees = mapper.map(request, Employees.class);
        employees = repository.save(employees);
        return Optional.ofNullable(mapper.map(employees, EmployeesDTO.class));
    }

    @Override
    public List<EmployeesDTO> getAll() {
        List<Employees> employees = repository.findAll();
        List<EmployeesDTO> responses = new ArrayList<>();
        employees.forEach(employee -> {
            EmployeesDTO response = mapper.map(employee, EmployeesDTO.class);
            responses.add(response);
        });
        return responses;
    }

    @Override
    public Optional<EmployeesDTO> getById(Long id) {
        Optional<Employees> employees = repository.findById(id);
        return employees.map(e -> mapper.map(e, EmployeesDTO.class));
    }

    @Override
    public Optional<EmployeesDTO> update(Long id, EmployeesDTO request) {
        Optional<Employees> employees = repository.findById(id);
        if (employees.isPresent()) {
            Employees employee = employees.get();
            employee.setDepartament(request.getDepartament());
            employee.setTitle(request.getTitle());
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
