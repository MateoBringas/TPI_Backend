package com.frc.utn.MS_Interesados.Repository;

import com.frc.utn.MS_Interesados.models.Interesado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresadoRepository extends JpaRepository<Interesado, Long> {
}
