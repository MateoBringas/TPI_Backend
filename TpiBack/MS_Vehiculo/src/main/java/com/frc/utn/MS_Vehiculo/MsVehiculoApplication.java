package com.frc.utn.MS_Vehiculo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsVehiculoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsVehiculoApplication.class, args);
	}

}
