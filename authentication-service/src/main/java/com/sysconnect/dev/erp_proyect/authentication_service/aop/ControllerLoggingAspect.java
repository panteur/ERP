package com.sysconnect.dev.erp_proyect.authentication_service.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
@Slf4j
public class ControllerLoggingAspect {

    // Define un pointcut para todos los métodos en cualquier clase dentro del paquete controller
    @Pointcut("within(com.sysconnect.dev.erp_proyect.authentication_service.controller..*)")
    public void controllerMethods() {}

    // Define un pointcut para todos los métodos en cualquier clase dentro del paquete service
    @Pointcut("within(com.sysconnect.dev.erp_proyect.authentication_service.service..*)")
    public void serviceMethods() {}

    @Around("controllerMethods() || serviceMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String username = "anonymous";

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
            username = authentication.getName();
        }

        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        log.info("AUDIT - [{}] User: '{}' - Executing {}.{}", formattedDateTime, username, className, methodName);

        Object result = joinPoint.proceed(); // Ejecuta el método original

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        log.info("AUDIT - [{}] User: '{}' - Finished {}.{} in {}ms", formattedDateTime, username, className, methodName, executionTime);

        return result;
    }
}
