package com.frc.utn.MS_Pruebas.Controller;

import com.frc.utn.MS_Pruebas.DTO.AgenciaDto;
import com.frc.utn.MS_Pruebas.DTO.ComentarioDto;
import com.frc.utn.MS_Pruebas.DTO.PosicionDto;
import com.frc.utn.MS_Pruebas.DTO.PruebaCompletaDTO;
import com.frc.utn.MS_Pruebas.Models.Prueba;
import com.frc.utn.MS_Pruebas.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.web.mappings.MappingsEndpoint;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pruebas")
public class PruebaController {

    @Autowired
    private PruebaCompletaDtoService pruebaCompletaService;
    @Autowired
    private ZonaService zonaService;
    @Autowired
    private MappingsEndpoint mappingsEndpoint;

    @GetMapping("/{id}")
    public ResponseEntity<PruebaCompletaDTO> getPruebaById(@PathVariable Long id){
        PruebaCompletaDTO pruebaCompletaDTO = pruebaCompletaService.getPruebaCompletaById(id);
        return ResponseEntity.ok(pruebaCompletaDTO);
    }

    @GetMapping
    public  ResponseEntity<List<PruebaCompletaDTO>> getAllPruebas(){
        List<PruebaCompletaDTO> pruebaCompletaDTOS = pruebaCompletaService.getPruebasCompletas();
        return ResponseEntity.ok(pruebaCompletaDTOS);
    }

    @PostMapping("/create")
    public ResponseEntity<PruebaCompletaDTO> createPrueba(@RequestBody Prueba prueba){
        return ResponseEntity.ok(pruebaCompletaService.createPruebaCompleta(prueba));
    }

    @GetMapping("/activas")
    public  ResponseEntity<List<PruebaCompletaDTO>> getAllPruebasActivas(){
        List<PruebaCompletaDTO> pruebaCompletaDTOS = pruebaCompletaService.getPruebasActivas();
        return ResponseEntity.ok(pruebaCompletaDTOS);
    }

    @PutMapping("/finalizar/{id}")
    public ResponseEntity<PruebaCompletaDTO> finalizarPrueba(@PathVariable Long id, @RequestBody ComentarioDto comentario){
        return ResponseEntity.ok(pruebaCompletaService.finalizarPrueba(id,comentario.getComentario()));
    }

    @GetMapping("/posicion/{id}")
    public ResponseEntity<PosicionDto> getPosicion(@PathVariable Long id){
        return ResponseEntity.ok(pruebaCompletaService.getPosicion(id));
    }

    @GetMapping("/validar/{id}")
    public ResponseEntity<String> validarPosicion(@PathVariable Long id){
        String mensaje = pruebaCompletaService.validarPosicion(id);
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/reportes/{idVehiculo}")
    public  ResponseEntity<String> getReportes(@PathVariable Long idVehiculo){
        String mensaje = pruebaCompletaService.getReportes(idVehiculo);
        return ResponseEntity.ok(mensaje);
    }
}
