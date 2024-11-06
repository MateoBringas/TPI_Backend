package com.frc.utn.MS_Posiciones.controllers;

import com.frc.utn.MS_Posiciones.DTO.VehiculoDto;
import com.frc.utn.MS_Posiciones.Models.Posicion;
import com.frc.utn.MS_Posiciones.Service.PosicionService;
import com.frc.utn.MS_Posiciones.Service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posiciones")
public class PosicionController {
    @Autowired
    private  PosicionService posicionService;
    @Autowired
    private  VehiculoService vehiculoService;

    @GetMapping("/{idPosicion}")
    public VehiculoDto posicionConVehiculo(@PathVariable Long idPosicion) {
        Posicion posicion = posicionService.getPosicion(idPosicion);
        VehiculoDto vehiculoDto = vehiculoService.obtenerVehiculo(posicion.getIdVehiculo());
        return vehiculoDto;
    }

    @GetMapping()
    public List<Posicion> posiciones() {
        return posicionService.getPosiciones();
    }
}
