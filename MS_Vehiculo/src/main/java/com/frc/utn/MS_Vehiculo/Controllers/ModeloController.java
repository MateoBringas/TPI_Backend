package com.frc.utn.MS_Vehiculo.Controllers;

import com.frc.utn.MS_Vehiculo.Models.Modelo;
import com.frc.utn.MS_Vehiculo.Services.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @PostMapping
    public ResponseEntity<Modelo> createModelo(@RequestBody Modelo modelo) {
        try {
            Modelo createdModelo = modeloService.save(modelo);
            return new ResponseEntity<>(createdModelo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Modelo>> getAllModelos() {
        try {
            List<Modelo> modelos = modeloService.findAll();
            return new ResponseEntity<>(modelos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> getModeloById(@PathVariable Long id) {
        try {
            Modelo modelo = modeloService.findById(id);
            return new ResponseEntity<>(modelo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> updateModelo(@PathVariable Long id, @RequestBody Modelo modelo) {
        try {
            Modelo updatedModelo = modeloService.update(id, modelo);
            return new ResponseEntity<>(updatedModelo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModelo(@PathVariable Long id) {
        try {
            modeloService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

