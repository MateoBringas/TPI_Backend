package com.frc.utn.MS_Notificacion.Controllers;

import com.frc.utn.MS_Notificacion.Models.Notificacion;
import com.frc.utn.MS_Notificacion.Service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @PostMapping()
    public ResponseEntity<Notificacion> enviarNotificacion(@RequestBody Notificacion notificacion) {
        Notificacion notificacionGuardada = notificacionService.enviarNotificacion(notificacion);
        return ResponseEntity.ok(notificacionGuardada);
    }
}
