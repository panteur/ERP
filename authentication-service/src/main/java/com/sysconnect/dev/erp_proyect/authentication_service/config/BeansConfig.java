package com.sysconnect.dev.erp_proyect.authentication_service.config;

import com.sysconnect.dev.erp_proyect.authentication_service.entity.Client;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

import java.util.Set;

@Configuration
public class BeansConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {
            clientRepository.findByClientId("entity-service-cli").ifPresent(client -> {
                Set<AuthorizationGrantType> grantTypes = client.getAuthorizationGrantTypes();
                if (!grantTypes.contains(AuthorizationGrantType.CLIENT_CREDENTIALS)) {
                    grantTypes.add(AuthorizationGrantType.CLIENT_CREDENTIALS);
                    client.setAuthorizationGrantTypes(grantTypes);
                    clientRepository.save(client);
                }
            });
        };
    }
}
