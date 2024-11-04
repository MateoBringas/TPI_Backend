package com.frc.utn.MS_Vehiculo.Repository;

import com.frc.utn.MS_Vehiculo.Models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Long> {
}
