package com.id;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class keycloakConfig {
  @Bean
  KeycloakSpringBootConfigResolver configResolver()
  {
	 return new KeycloakSpringBootConfigResolver();
  }  
}
