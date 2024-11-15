package com.frc.utn.MS_Pruebas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZonaRestringidasDto {
    private CoordenadasDto noroeste;
    private CoordenadasDto sureste;
}
