package com.sysconnect.dev.erp_proyect.entity_service.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor(OAuth2AuthorizedClientManager authorizedClientManager) {
        return requestTemplate -> {
            // Define la solicitud de autorización para el cliente "master-data-service"
            OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest
                    .withClientRegistrationId("master-data-service")
                    .principal("entity-service") // El nombre del servicio que solicita el token
                    .build();

            // Obtiene el cliente autorizado (y con él, el token de acceso)
            OAuth2AuthorizedClient authorizedClient = authorizedClientManager.authorize(authorizeRequest);

            if (authorizedClient != null && authorizedClient.getAccessToken() != null) {
                OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
                // Añade la cabecera "Authorization: Bearer <token>" a la solicitud Feign
                requestTemplate.header("Authorization", "Bearer " + accessToken.getTokenValue());
            }
        };
    }
}
