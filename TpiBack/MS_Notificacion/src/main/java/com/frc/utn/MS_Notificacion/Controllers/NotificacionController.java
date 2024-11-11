package com.frc.utn.MS_Notificacion.Controllers;

import com.frc.utn.MS_Notificacion.Models.Notificacion;
import com.frc.utn.MS_Notificacion.Service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;
    @GetMapping()
    public ResponseEntity<String> enviarNotificacion(@RequestBody Notificacion notificacion) {
        notificacionService.enviarNotificacion(notificacion);
        return ResponseEntity.ok("Notificacion enviada com sucesso");
    }

}
