package com.frc.utn.MS_Notificacion.Repository;

import com.frc.utn.MS_Notificacion.Models.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}
