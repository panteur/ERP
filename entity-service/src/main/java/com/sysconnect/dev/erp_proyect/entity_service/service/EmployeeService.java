package com.sysconnect.dev.erp_proyect.entity_service.service;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    public Employee findById(Long id);
    public Employee findByEntitie_Id(Long id);
    public List<Employee> findByStatusId(Long statusId);    public List<Employee> findAll();
    public Employee updateStatus(Long id, Long statusId);

    public Employee save(Employee employee);
    public Employee update(Employee employee);
    public Employee delete(Long id);

}
