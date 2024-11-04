package com.frc.utn.MS_Empleados.Repository;

import com.frc.utn.MS_Empleados.Models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
