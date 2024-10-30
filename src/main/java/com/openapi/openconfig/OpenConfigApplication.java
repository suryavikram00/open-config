package com.openapi.openconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.open.feign_client.inter_process_communication")
public class OpenConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenConfigApplication.class, args);
	}

}
