package com.frc.utn.MS_Posiciones.Repository;

import com.frc.utn.MS_Posiciones.Models.Posicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosicionRepository extends JpaRepository<Posicion, Long> {
}
