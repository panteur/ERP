package com.sysconnect.dev.erp_proyect.master_data_service;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimeZone;


@SpringBootApplication
public class MasterDataServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(MasterDataServiceApplication.class);

	@PostConstruct
	void started() { TimeZone.setDefault(TimeZone.getTimeZone("UTC")); }

	public static void main(String[] args) {
		SpringApplication.run(MasterDataServiceApplication.class, args);
	}



}
