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

    public void enviarNotificacion(Notificacion notificacion) {
        List<TelefonoDestinatario>  telefonosDestinatario = notificacion.getTelefonosDestinatario();
        for (TelefonoDestinatario telefonoDestinatario : telefonosDestinatario){
            enviarSMS(telefonoDestinatario,notificacion.getMensaje());
            notificacionRepository.save(notificacion);
        }
    }

    public void enviarSMS(TelefonoDestinatario telefonoDestinatario, String mensaje){
        System.out.println("Enviando SMS a " + telefonoDestinatario + ": " + mensaje);
    }
}
