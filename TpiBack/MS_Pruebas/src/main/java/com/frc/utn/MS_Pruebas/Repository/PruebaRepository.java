package com.frc.utn.MS_Pruebas.Repository;

import com.frc.utn.MS_Pruebas.Models.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba,Long> {
}
