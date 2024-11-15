package com.frc.utn.MS_Pruebas.Service;

import com.frc.utn.MS_Pruebas.DTO.AgenciaDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZonaService {
    private RestTemplate restTemplate;
    private String url = "https://labsys.frc.utn.edu.ar/apps-disponibilizadas/backend/api/v1/configuracion/";

    public ZonaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AgenciaDto getAgenciaZonaRestringida(){
        return restTemplate.getForObject(url, AgenciaDto.class);
    }
}
