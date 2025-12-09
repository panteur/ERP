package com.sysconnect.dev.erp_proyect.entity_service.repository;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Employee;
import com.sysconnect.dev.erp_proyect.entity_service.enums.CivilState;
import com.sysconnect.dev.erp_proyect.entity_service.enums.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where e.entitie.id = ?1")
    Optional<Employee> findByEntitie_Id(Long id);

    @Query("select e from Employee e where e.statusId = ?1")
    List<Employee> findByStatusId(Long statusId);

    @Query("SELECT e FROM Employee e WHERE LOWER(e.names) LIKE LOWER(CONCAT('%', :searchText, '%')) OR LOWER(e.lastNames) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    List<Employee> findByNamesOrLastNamesContaining(@Param("searchText") String searchText);

    @Query("select e from Employee e where e.birthDate = ?1")
    List<Employee> findByBirthDate(Date birthDate);

    @Query("select e from Employee e where e.sex = ?1")
    List<Employee> findBySex(Sex sex);

    @Query("select e from Employee e where e.civilState = ?1")
    List<Employee> findByCivilState(CivilState civilState);

    @Query("select e from Employee e where e.entryDate between ?1 and ?2")
    List<Employee> findByEntryDateBetween(Date entryDateStart, Date entryDateEnd);
}