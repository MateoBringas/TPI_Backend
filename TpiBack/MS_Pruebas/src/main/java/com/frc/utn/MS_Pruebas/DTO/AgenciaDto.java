package com.frc.utn.MS_Pruebas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgenciaDto {
    private CoordenadasDto coordenadasAgencia;
    private int radioAdmitidoKm;
    private List<ZonaRestringidasDto> zonasRestringidas;
}
