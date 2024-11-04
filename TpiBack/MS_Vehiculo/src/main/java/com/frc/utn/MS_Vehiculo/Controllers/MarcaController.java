package com.frc.utn.MS_Vehiculo.Controllers;

import com.frc.utn.MS_Vehiculo.Models.Marca;
import com.frc.utn.MS_Vehiculo.Services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @PostMapping
    public ResponseEntity<Marca> createMarca(@RequestBody Marca marca) {
        try {
            Marca createdMarca = marcaService.save(marca);
            return new ResponseEntity<>(createdMarca, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Marca>> getAllMarcas() {
        try {
            List<Marca> marcas = marcaService.findAll();
            return new ResponseEntity<>(marcas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> getMarcaById(@PathVariable Long id) {
        try {
            Marca marca = marcaService.findById(id);
            return new ResponseEntity<>(marca, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> updateMarca(@PathVariable Long id, @RequestBody Marca marca) {
        try {
            Marca updatedMarca = marcaService.update(id, marca);
            return new ResponseEntity<>(updatedMarca, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarca(@PathVariable Long id) {
        try {
            marcaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
