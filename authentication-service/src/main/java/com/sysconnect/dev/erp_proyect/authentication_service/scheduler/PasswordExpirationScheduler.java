package com.sysconnect.dev.erp_proyect.authentication_service.scheduler;

import com.sysconnect.dev.erp_proyect.authentication_service.entity.AppUser;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.AppUserRepository;
import com.sysconnect.dev.erp_proyect.authentication_service.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PasswordExpirationScheduler {

    private final AppUserRepository appUserRepository;
    private final EmailService emailService;

    /**
     * Tarea programada que se ejecuta todos los días a la 1:00 AM.
     * Busca usuarios cuya contraseña expira en exactamente 3 días y les envía una notificación.
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void notifyPasswordExpirationInThreeDays() {
        LocalDate threeDaysFromNow = LocalDate.now().plusDays(3);
        Date targetDate = Date.from(threeDaysFromNow.atStartOfDay(ZoneId.systemDefault()).toInstant());

        log.info("Buscando usuarios cuya contraseña expira en 3 días (fecha: {})", threeDaysFromNow);
        List<AppUser> usersToNotify = appUserRepository.findByPasswordExpDate(targetDate);

        for (AppUser user : usersToNotify) {
            log.info("Enviando correo de advertencia de expiración a {}", user.getUsername());
            String subject = "Advertencia: Tu contraseña está a punto de expirar";
            String body = "Hola " + user.getUsername() + ",\n\n"
                    + "Tu contraseña expirará en 3 días. Por favor, actualízala para evitar interrupciones en el servicio.";
            emailService.sendEmail(user.getEmail(), subject, body);
        }
    }

    /**
     * Tarea programada que se ejecuta todos los días a la 1:05 AM.
     * Busca usuarios cuya contraseña expira hoy y les envía una notificación final.
     */
    @Scheduled(cron = "0 5 1 * * ?")
    public void notifyPasswordExpirationToday() {
        LocalDate today = LocalDate.now();
        Date targetDate = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());

        log.info("Buscando usuarios cuya contraseña expira hoy (fecha: {})", today);
        List<AppUser> usersToNotify = appUserRepository.findByPasswordExpDate(targetDate);

        for (AppUser user : usersToNotify) {
            log.info("Enviando correo de último aviso de expiración a {}", user.getUsername());
            String subject = "Tu contraseña ha expirado";
            String body = "Hola " + user.getUsername() + ",\n\n"
                    + "Tu contraseña ha expirado hoy. Por favor, actualízala lo antes posible.";
            emailService.sendEmail(user.getEmail(), subject, body);
        }
    }
}
