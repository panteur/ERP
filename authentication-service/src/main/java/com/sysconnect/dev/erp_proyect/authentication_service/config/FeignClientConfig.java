package com.sysconnect.dev.erp_proyect.authentication_service.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

/**
 * Configuración de Feign para añadir automáticamente tokens de acceso OAuth2 a las solicitudes.
 * Este interceptor obtiene un token de acceso del OAuth2AuthorizedClientManager
 * para el cliente registrado con el ID "master-data-service" y lo añade
 * a la cabecera de autorización de cada solicitud Feign.
 */
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor(OAuth2AuthorizedClientManager authorizedClientManager) {
        return requestTemplate -> {
            // Define la solicitud de autorización para el cliente "master-data-service"
            OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest
                    .withClientRegistrationId("master-data-service")
                    .principal("authentication-service") // El nombre del servicio que solicita el token
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
