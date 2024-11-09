package com.frc.utn.MS_Pruebas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PruebaCompletaDTO {
    private Long id;
    private VehiculoDto vehiculoDto;
    private EmpleadoDto empleadoDto;
    private InteresadoDto interesadoDto;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private String comentarios;

}
