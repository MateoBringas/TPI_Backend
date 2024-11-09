package com.frc.utn.MS_Pruebas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InteresadoDto {
        private Long id;
        private String tipo_documento;
        private String documento;
        private String nombre;
        private String apellido;
        private int restringido;
        private int nro_licencia;
        private LocalDate fecha_vencimiento_licencia;

}
