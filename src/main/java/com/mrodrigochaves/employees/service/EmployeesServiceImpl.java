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

    @Autowired
    private EmployeesRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Optional<EmployeesDTO> create(EmployeesDTO request) {

        Employees employees = mapper.map(request, Employees.class);
        repository.saveAndFlush(employees);

        return Optional.of(mapper.map(employees, EmployeesDTO.class));
    }

    @Override
    public List<EmployeesDTO> getAll() {

        List<Employees> employee = repository.findAll();

        List<EmployeesDTO> responses = new ArrayList<>();
        employee.forEach(employees -> {
            EmployeesDTO response = mapper.map(employees, EmployeesDTO.class);
            responses.add(response);
        });
        return responses;

    }

    @Override
    public Optional<EmployeesDTO> getById(Long id) {
        Optional<Employees> employees = repository.findById(id);
        if (employees.isPresent()) {
            return Optional.of(mapper.map(employees.get(), EmployeesDTO.class));
        }
        return Optional.empty();
    }

    @Override
public Optional<EmployeesDTO> getByName(String name) {
    Optional<Employees> employees = repository.findByName(name);
    return employees.map(e -> mapper.map(e, EmployeesDTO.class));
}



    @Override
    public Optional<EmployeesDTO> update(Long id, EmployeesDTO request) {
        Optional<Employees> employees = repository.findById(id);
        if (employees.isPresent()) {
            employees.get().setDepartament(request.getDepartament());
            employees.get().setTitle(request.getTitle());
            repository.save(employees.get());
            return Optional.of(mapper.map(employees.get(), EmployeesDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean inactive(Long id) {
        Optional<Employees> employees = repository.findById(id);
        if (employees.isPresent()) {
            employees.get().setAvailable(false);
            return true;
        }
        return false;
    }

}
