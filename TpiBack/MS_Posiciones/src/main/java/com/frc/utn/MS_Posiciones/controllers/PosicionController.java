package com.frc.utn.MS_Posiciones.controllers;

import com.frc.utn.MS_Posiciones.DTO.PosicionVehiculoDto;
import com.frc.utn.MS_Posiciones.DTO.VehiculoDto;
import com.frc.utn.MS_Posiciones.Models.Posicion;
import com.frc.utn.MS_Posiciones.Service.PosicionService;
import com.frc.utn.MS_Posiciones.Service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/posiciones")
public class PosicionController {
    @Autowired
    private  PosicionService posicionService;
    @Autowired
    private  VehiculoService vehiculoService;

    @PostMapping()
    public ResponseEntity<Posicion> savePosicion(@RequestBody Posicion posicion){
        posicionService.save(posicion);
        return ResponseEntity.ok(posicion);
    }

    @GetMapping("/{idPosicion}")
    public ResponseEntity<PosicionVehiculoDto> posicionConVehiculo(@PathVariable Long idPosicion) {
        try {
            Posicion posicion = posicionService.obtenerPosicion(idPosicion);

            VehiculoDto vehiculoDto = vehiculoService.obtenerVehiculo(posicion.getIdVehiculo());

            PosicionVehiculoDto posicionVehiculo = new PosicionVehiculoDto(
                    posicion.getId(),
                    posicion.getFechaHora(),
                    posicion.getLatitud(),
                    posicion.getLongitud(),
                    vehiculoDto
            );
            return ResponseEntity.ok(posicionVehiculo);
        } catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<PosicionVehiculoDto>> obtenerPosicionVehiculo(){
        List<Posicion> posiciones = posicionService.obtenerPosiciones();
        List<PosicionVehiculoDto> posicionVehiculoDtos = new ArrayList<>();
        for(Posicion posicion : posiciones){
            VehiculoDto vehiculoDto = vehiculoService.obtenerVehiculo(posicion.getIdVehiculo());
            PosicionVehiculoDto posicionVehiculoDto = new PosicionVehiculoDto(
                    posicion.getId(),
                    posicion.getFechaHora(),
                    posicion.getLatitud(),
                    posicion.getLongitud(),
                    vehiculoDto
            );
            posicionVehiculoDtos.add(posicionVehiculoDto);
        }
        return ResponseEntity.ok(posicionVehiculoDtos);
    }

    @PutMapping("/{idPosicion}")
    public ResponseEntity<Posicion> modificarPosicion(@PathVariable Long idPosicion, @RequestBody Posicion posicion){
        Posicion posicionActual = posicionService.obtenerPosicion(idPosicion);
        posicionActual.setFechaHora(LocalDateTime.now());
        posicionActual.setLongitud(posicion.getLongitud());
        posicionActual.setLatitud(posicion.getLatitud());
        posicionService.save(posicionActual);
        return ResponseEntity.ok(posicionActual);
    }

    @DeleteMapping("/{idPosicion}")
    public ResponseEntity<Object> eliminarPosicion(@PathVariable Long idPosicion){
        Posicion posicion = posicionService.obtenerPosicion(idPosicion);
        posicionService.delete(posicion);
        return ResponseEntity.ok().build();
    }
}
