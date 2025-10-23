package com.sysconnect.dev.erp_proyect.entity_service.service;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Person;

import java.util.Date;
import java.util.List;

public interface PersonService {

    public Person findById(Long id);
    public Person findByEntitie_Id(Long id);
    public List<Person>  findAll();
    public List<Person> findByBirthDate(Date birthDate);

    public Person save(Person person);
    public Person update(Person person);
    public Person delete(Long id);
}
