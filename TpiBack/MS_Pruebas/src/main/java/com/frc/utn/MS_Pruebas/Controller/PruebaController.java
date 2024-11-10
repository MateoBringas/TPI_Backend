package com.frc.utn.MS_Pruebas.Controller;

import com.frc.utn.MS_Pruebas.DTO.ComentarioDto;
import com.frc.utn.MS_Pruebas.DTO.PruebaCompletaDTO;
import com.frc.utn.MS_Pruebas.Models.Prueba;
import com.frc.utn.MS_Pruebas.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pruebas")
public class PruebaController {

    @Autowired
    private PruebaCompletaDtoService pruebaCompletaService;

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

}
