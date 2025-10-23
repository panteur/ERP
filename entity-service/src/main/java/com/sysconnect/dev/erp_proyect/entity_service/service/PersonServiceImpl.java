package com.sysconnect.dev.erp_proyect.entity_service.service;

import com.sysconnect.dev.erp_proyect.entity_service.entity.Person;
import com.sysconnect.dev.erp_proyect.entity_service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findById(Long id) {return personRepository.findById(id).orElse(null);}

    @Override
    public Person findByEntitie_Id(Long id) {return personRepository.findByEntitie_Id(id).orElse(null);}

    @Override
    public List<Person>  findAll() {return personRepository.findAll();}

    @Override
    public List<Person> findByBirthDate(Date birthDate) {return personRepository.findByBirthDate(birthDate);}

    @Override
    public Person save(Person person) {return personRepository.save(person);}

    @Override
    public Person update(Person person) {
        Person personBD = personRepository.findById(person.getId()).orElse(null);
        if (personBD == null) return null;
        personBD.setNames(person.getNames());
        personBD.setLastNames(person.getLastNames());
        personBD.setBirthDate(person.getBirthDate());
        personBD.setSex(person.getSex());
        personBD.setNationality(person.getNationality());

        return personRepository.save(personBD);
    }

    @Override
    public Person delete(Long id) {
        Person personBD = personRepository.findById(id).orElse(null);
        if (personBD == null) return null;
        personRepository.delete(personBD);
        return personBD;
    }
}
