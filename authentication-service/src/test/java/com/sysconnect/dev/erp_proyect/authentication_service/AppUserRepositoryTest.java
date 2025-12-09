package com.sysconnect.dev.erp_proyect.authentication_service;

import com.sysconnect.dev.erp_proyect.authentication_service.entity.AppUser;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.AppUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(properties = {"spring.cloud.config.enabled=false"})
public class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    private AppUser user1;
    private AppUser user2;

    @BeforeEach
    void setUp() {
        // Limpiar la base de datos antes de cada prueba
        appUserRepository.deleteAll();

        // Crear datos de prueba comunes
        user1 = AppUser.builder()
                .username("testuser1")
                .password("password")
                .email("test1@example.com")
                .statusId(1L)
                .verificationToken(UUID.randomUUID().toString())
                .disabled(false)
                .build();

        user2 = AppUser.builder()
                .username("testuser2")
                .password("password")
                .email("test2@example.com")
                .statusId(2L)
                .disabled(true)
                .build();

        appUserRepository.saveAll(List.of(user1, user2));
    }

    @Test
    void whenFindByUsername_thenReturnAppUser() {
        Optional<AppUser> foundUser = appUserRepository.findByUsername("testuser1");
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getUsername()).isEqualTo("testuser1");
    }

    @Test
    void whenFindByEmail_thenReturnAppUser() {
        Optional<AppUser> foundUser = appUserRepository.findByEmail("test2@example.com");
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getEmail()).isEqualTo("test2@example.com");
    }

    @Test
    void whenFindByVerificationToken_thenReturnAppUser() {
        String token = user1.getVerificationToken();
        Optional<AppUser> foundUser = appUserRepository.findByVerificationToken(token);
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getVerificationToken()).isEqualTo(token);
    }

    @Test
    void whenFindByStatusId_thenReturnUserList() {
        List<AppUser> foundUsers = appUserRepository.findByStatusId(1L);
        assertThat(foundUsers).hasSize(1);
        assertThat(foundUsers.get(0).getUsername()).isEqualTo("testuser1");
    }


    @Test
    void whenFindByDisabled_thenReturnUserList() {
        List<AppUser> disabledUsers = appUserRepository.findByDisabled(true);
        assertThat(disabledUsers).hasSize(1);
        assertThat(disabledUsers.get(0).getUsername()).isEqualTo("testuser2");

        List<AppUser> enabledUsers = appUserRepository.findByDisabled(false);
        assertThat(enabledUsers).hasSize(1);
        assertThat(enabledUsers.get(0).getUsername()).isEqualTo("testuser1");
    }

    @Test
    void whenFindByUsernameAndRut_withWrongRut_thenReturnEmpty() {
        Optional<AppUser> foundUser = appUserRepository.findByUsernameAndRut("testuser1", "99999999-9");
        assertThat(foundUser).isNotPresent();
    }
}
