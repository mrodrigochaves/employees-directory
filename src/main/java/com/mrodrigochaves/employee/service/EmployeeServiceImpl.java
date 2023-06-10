package com.mrodrigochaves.employee.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrodrigochaves.employee.dto.EmployeeDTO;
import com.mrodrigochaves.employee.model.Employee;
import com.mrodrigochaves.employee.repository.EmployeeRepository;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<EmployeeDTO> create(@Valid EmployeeDTO request) {
        Employee employee = mapper.map(request, Employee.class);
        Employee savedEmployee = repository.saveAndFlush(employee);
        return Optional.of(mapper.map(savedEmployee, EmployeeDTO.class));
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<Employee> employees = repository.findAll();
        return mapEmployeeListToDTO(employees);
    }

    @Override
    public Optional<EmployeeDTO> getById(Long id) {
        return repository.findById(id)
                .map(employee -> mapper.map(employee, EmployeeDTO.class));
    }

    @Override
    public Optional<EmployeeDTO> deleteById(Long id) {
        Optional<Employee> employee = repository.findById(id);
        employee.ifPresent(emp -> repository.deleteById(id));
        return employee.map(emp -> mapper.map(emp, EmployeeDTO.class));
    }

    @Override
    public List<EmployeeDTO> getByLastName(String lastName) {
        List<Employee> employees = repository.findByLastName(lastName);
        return mapEmployeeListToDTO(employees);
    }

    @Override
    public List<EmployeeDTO> getByDepartment(String department) {
        List<Employee> employees = repository.findByDepartment(department);
        return mapEmployeeListToDTO(employees);
    }

    @Override
    public List<EmployeeDTO> getByTitle(String title) {
        List<Employee> employees = repository.findByTitle(title);
        return mapEmployeeListToDTO(employees);
    }

    @Override
    public Optional<EmployeeDTO> update(Long id, @Valid EmployeeDTO request) {
        Optional<Employee> employeeOptional = repository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setDepartment(request.getDepartment());
            employee.setTitle(request.getTitle());
            repository.save(employee);
            return Optional.of(mapper.map(employee, EmployeeDTO.class));
        }
        return Optional.empty();
    }

    private List<EmployeeDTO> mapEmployeeListToDTO(List<Employee> employees) {
        return employees.stream()
                .map(employee -> mapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }
}
