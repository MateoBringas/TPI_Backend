package com.frc.utn.MS_Pruebas.Service;

import com.frc.utn.MS_Pruebas.DTO.InteresadoDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InteresadoService {
    private final RestTemplate restTemplate;
    private final String url="http://localhost:8091/api/interesados";

    public InteresadoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public InteresadoDto getInteresadoById(Long id){
        String urlId = url + "/" + id;
        return restTemplate.getForObject(urlId,InteresadoDto.class);
    }
    public void updateInteresado(InteresadoDto interesadoDto) {
        String urlId = url + "/" + interesadoDto.getId();
        restTemplate.put(urlId, interesadoDto);
    }
}
