package com.frc.utn.MS_Posiciones.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDto {
    private Long id;
    private String patente;
    private ModeloDto modelo;
}
