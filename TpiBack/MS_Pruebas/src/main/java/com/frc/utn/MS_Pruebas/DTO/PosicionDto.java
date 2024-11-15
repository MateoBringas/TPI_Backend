package com.frc.utn.MS_Pruebas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosicionDto {
    private Long id;
    private LocalDateTime fechaHora;
    private Double latitud;
    private Double longitud;
    private VehiculoDto vehiculo;
}
