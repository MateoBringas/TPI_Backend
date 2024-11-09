package com.frc.utn.MS_Pruebas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDto {
    private Long legajo;
    private String nombre;
    private String apellido;
    private int telefonoContacto;
}
