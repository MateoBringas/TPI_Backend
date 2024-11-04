package com.frc.utn.MS_Vehiculo.Repository;

import com.frc.utn.MS_Vehiculo.Models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {
}
