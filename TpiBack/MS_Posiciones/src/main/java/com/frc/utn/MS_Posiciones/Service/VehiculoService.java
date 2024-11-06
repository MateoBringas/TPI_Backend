package com.frc.utn.MS_Posiciones.Service;

import com.frc.utn.MS_Posiciones.DTO.VehiculoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class VehiculoService {

    @Autowired
    private final RestTemplate restTemplate;
    private final String vehiculoUrl = "http://localhost:8093/api/vehiculos";

    public VehiculoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public VehiculoDto obtenerVehiculo(int idVehiculo) {
        String url = vehiculoUrl + "/" + idVehiculo;
        VehiculoDto vehiculoDto = restTemplate.getForObject(url, VehiculoDto.class);
        System.out.println("Vehiculo recibido: " + vehiculoDto);  // Log para depurar
        return vehiculoDto;
    }
}
