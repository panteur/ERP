package com.sysconnect.dev.erp_proyect.authentication_service.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

@Aspect
@Component
@Slf4j
public class RutCleaningAspect {

    /**
     * Define un pointcut para todos los métodos públicos en cualquier clase dentro del paquete controller.
     */
    @Pointcut("within(com.sysconnect.dev.erp_proyect.authentication_service.controller..*)")
    public void controllerMethods() {}

    @Around("controllerMethods()")
    public Object cleanRutInArguments(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Parameter[] parameters = signature.getMethod().getParameters();

        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            Parameter parameter = parameters[i];

            // Caso 1: El argumento es un String y el parámetro se llama "rut"
            if (arg instanceof String && "rut".equalsIgnoreCase(parameter.getName())) {
                args[i] = ((String) arg).replace(".", "");
                log.trace("RUT limpio en parámetro String: {}", args[i]);
            }
            // Caso 2: El argumento es un DTO de nuestro paquete
            else if (arg != null && arg.getClass().getPackageName().startsWith("com.sysconnect.dev.erp_proyect.authentication_service.dto")) {
                try {
                    Field rutField = arg.getClass().getDeclaredField("rut");
                    rutField.setAccessible(true);
                    Object rutValue = rutField.get(arg);
                    if (rutValue instanceof String) {
                        String cleanedRut = ((String) rutValue).replace(".", "");
                        rutField.set(arg, cleanedRut);
                        log.trace("RUT limpio dentro del DTO {}: {}", arg.getClass().getSimpleName(), cleanedRut);
                    }
                } catch (NoSuchFieldException e) {
                    // El DTO no tiene un campo 'rut', no hacemos nada.
                } catch (Exception e) {
                    log.error("Error al limpiar el RUT en el DTO", e);
                }
            }
        }

        // Continúa con la ejecución del método original, pero con los argumentos ya modificados.
        return joinPoint.proceed(args);
    }
}
