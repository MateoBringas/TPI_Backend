package com.frc.utn.MS_Pruebas.Service;

import com.frc.utn.MS_Pruebas.DTO.EmpleadoDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmpleadoService {

    private final RestTemplate restTemplate;
    private final String url = "http://localhost:8090/api/empleados";

    public EmpleadoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public EmpleadoDto getEmpleadoById(Long id){
        String urlId = url +"/"+ id;
        return restTemplate.getForObject(urlId,EmpleadoDto.class);
    }
}
