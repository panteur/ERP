package com.sysconnect.dev.erp_proyect.entity_service.repository;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("select p from Person p where p.entitie.id = ?1")
    Optional<Person> findByEntitie_Id(Long id);

    @Query("select p from Person p where p.birthDate = ?1")
    List<Person> findByBirthDate(Date birthDate);
}