package com.frc.utn.MS_Pruebas.Service;

import com.frc.utn.MS_Pruebas.DTO.PosicionDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PosicionService {

    private RestTemplate restTemplate;
    private String url = "http://localhost:8094/api/posiciones";

    public PosicionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PosicionDto posicionById(Long id){
        return restTemplate.getForObject(url+"/"+id, PosicionDto.class);
    }
}
