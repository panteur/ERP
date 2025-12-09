package com.sysconnect.dev.erp_proyect.entity_service.aspect;

import com.sysconnect.dev.erp_proyect.entity_service.dto.CustomerCreateDto;
import com.sysconnect.dev.erp_proyect.entity_service.entity.Customer;
import com.sysconnect.dev.erp_proyect.entity_service.utils.CapitalizeWords;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;

@Aspect
@Component
public class CapitalizeAspect {

    @Pointcut("execution(* com.sysconnect.dev.erp_proyect.entity_service.service.CustomerServiceImpl.save(..)) || execution(* com.sysconnect.dev.erp_proyect.entity_service.service.CustomerServiceImpl.update(..))")
    public void customerServiceMethods() {}

    @Before("customerServiceMethods()")
    public void capitalizeCustomerNames(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Customer) {
                Customer customer = (Customer) arg;
                if (customer.getNames() != null) {
                    customer.setNames(CapitalizeWords.capitalize(customer.getNames()));
                }
                if (customer.getLastNames() != null) {
                    customer.setLastNames(CapitalizeWords.capitalize(customer.getLastNames()));
                }
            } else if (arg instanceof CustomerCreateDto) { // <-- LÓGICA AÑADIDA
                CustomerCreateDto dto = (CustomerCreateDto) arg;
                if (dto.getNames() != null) {
                    dto.setNames(CapitalizeWords.capitalize(dto.getNames()));
                }
                if (dto.getLastNames() != null) {
                    dto.setLastNames(CapitalizeWords.capitalize(dto.getLastNames()));
                }
            }
        }
    }
}
