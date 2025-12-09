package com.sysconnect.dev.erp_proyect.entity_service.service;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Employee;
import com.sysconnect.dev.erp_proyect.entity_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee findById(Long id) {return employeeRepository.findById(id).orElse(null);}

    @Override
    public Employee findByEntitie_Id(Long id) {return employeeRepository.findByEntitie_Id(id).orElse(null);}

    @Override
    public List<Employee> findByStatusId(Long statusId) {return employeeRepository.findByStatusId(statusId);}

    @Override
    public List<Employee> findAll() {return employeeRepository.findAll();}


    @Override
    public Employee updateStatus(Long id, Long statusId) {
        Employee employeeDB = employeeRepository.findById(id).orElse(null);
        if (employeeDB == null) return null;
        employeeDB.setStatusId(statusId);
        return employeeRepository.save(employeeDB);

    }

    @Override
    public Employee save(Employee employee) {return employeeRepository.save(employee);}

    @Override
    public Employee update(Employee employee) {
        Employee employeeDB = employeeRepository.findById(employee.getId()).orElse(null);
        if (employeeDB == null) return null;
        employeeDB.setStatusId(employee.getStatusId());
        return employeeRepository.save(employeeDB);
    }

    @Override
    public Employee delete(Long id) {
        Employee employeeDB = employeeRepository.findById(id).orElse(null);
        if (employeeDB == null) return null;
        employeeRepository.delete(employeeDB);
        return employeeDB;
    }
}
