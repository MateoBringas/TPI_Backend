package com.frc.utn.MS_Notificacion.Service;

import com.frc.utn.MS_Notificacion.Models.Notificacion;
import com.frc.utn.MS_Notificacion.Models.TelefonoDestinatario;
import com.frc.utn.MS_Notificacion.Repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificacionService {
    @Autowired
    private NotificacionRepository notificacionRepository;

    //1-E
    public Notificacion enviarNotificacion(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

}
