package com.sysconnect.dev.erp_proyect.entity_service.utils;

import com.sysconnect.dev.erp_proyect.entity_service.dto.EmployeeDto;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Employee;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Entitie;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Person;
import com.sysconnect.dev.erp_proyect.entity_service.feignclients.StatusFeignClient;
import com.sysconnect.dev.erp_proyect.entity_service.model.Status;
import com.sysconnect.dev.erp_proyect.entity_service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeToEmployeeDto {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private StatusFeignClient statusFeignClient;


    public List<EmployeeDto> toList(List<Employee> list){
        List<EmployeeDto> dtoList = new ArrayList<>();
        EmployeeDto employeeDto;
        if(list == null) return null;
        for (Employee employeeUnit : list){
            employeeDto = toDto(employeeUnit);
            dtoList.add(employeeDto);
        }
        return dtoList;
    }

    public EmployeeDto toDto(Employee employee){
        Entitie entitie = employee.getEntitie();
        Person person = personRepository.findByEntitie_Id(entitie.getId()).orElse(null);
        EmployeeDto employeeDto;
        employeeDto = new EmployeeDto().builder()
                .id(employee.getEntitie().getId())
                .rut(entitie.getRut())
                .names(person.getNames())
                .lastNames(person.getLastNames())
                .birthDate(person.getBirthDate())
                .sex(person.getSex())
                .endContract(employee.getEndContract())
                .contractType(employee.getContractType())
                .statusId(employee.getStatusId())
                .status(statusFeignClient.getStatus(employee.getStatusId()))
                .nationality(person.getNationality())
                .build();
        return employeeDto;
    }

}
