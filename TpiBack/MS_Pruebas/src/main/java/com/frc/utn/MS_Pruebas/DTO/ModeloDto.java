package com.frc.utn.MS_Pruebas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModeloDto {
    private Long id;
    private MarcaDto id_marca;  // Relación con la marca del modelo
    private String descripcion;
}
