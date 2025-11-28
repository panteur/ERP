package com.sysconnect.dev.erp_proyect.authentication_service;

import com.sysconnect.dev.erp_proyect.authentication_service.entity.Role;
import com.sysconnect.dev.erp_proyect.authentication_service.enums.RoleName;
import com.sysconnect.dev.erp_proyect.authentication_service.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuthenticationServiceApplication /*implements CommandLineRunner*/ {

    /*@Autowired
	private RoleRepository roleRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		Role adminRole = Role.builder().role(RoleName.ROLE_ADMIN).build();
		Role userRole = Role.builder().role(RoleName.ROLE_USER).build();
		roleRepository.save(adminRole);
		roleRepository.save(userRole);
	}*/
}
