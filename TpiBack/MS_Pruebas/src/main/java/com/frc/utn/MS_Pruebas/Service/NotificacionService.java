package com.frc.utn.MS_Pruebas.Service;


import com.frc.utn.MS_Pruebas.DTO.NotificacionDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificacionService {
    private RestTemplate restTemplate;
    private String url = "http://localhost:8095/api/notificaciones";

    public NotificacionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public NotificacionDto enviarNotificacion(NotificacionDto notificacionDto) {
        System.out.println(notificacionDto);
        return restTemplate.postForObject(url, notificacionDto, NotificacionDto.class);
    }
}
