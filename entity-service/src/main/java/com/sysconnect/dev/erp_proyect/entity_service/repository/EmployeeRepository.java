package com.sysconnect.dev.erp_proyect.entity_service.repository;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where e.entitie.id = ?1")
    Optional<Employee> findByEntitie_Id(Long id);

    @Query("select e from Employee e where e.statusId = ?1")
    List<Employee> findByStatusId(Long statusId);

    @Query("select e from Employee e where e.endContract between ?1 and ?2")
    List<Employee> findByEndContractBetween(Date endContractStart, Date endContractEnd);



}