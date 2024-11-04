package com.frc.utn.MS_Interesados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsInteresadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsInteresadosApplication.class, args);
	}

}
