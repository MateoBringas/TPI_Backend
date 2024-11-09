package com.frc.utn.MS_Pruebas.Service;

import com.frc.utn.MS_Pruebas.DTO.VehiculoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VehiculoService {

    private final RestTemplate restTemplate;
    private final String url = "http://localhost:8093/api/vehiculos";


    public VehiculoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public VehiculoDto getVehiculoById(Long id){
        String urlID = url + "/" + id;
        return restTemplate.getForObject(urlID, VehiculoDto.class);
    }
}
