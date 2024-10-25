package com.frc.utn.MS_Interesados.Controllers;

import com.frc.utn.MS_Interesados.Service.InteresadoService;
import com.frc.utn.MS_Interesados.models.Interesado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interesados")
public class InteresadoController {

    @Autowired
    private InteresadoService interesadoService;

    @PostMapping
    public ResponseEntity<Interesado> createInteresado(@RequestBody Interesado interesado) {
        try {
            Interesado createdInteresado = interesadoService.save(interesado);
            return new ResponseEntity<>(createdInteresado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Interesado>> getAllInteresado() {
        try {
            List<Interesado> interesados = interesadoService.findAll();
            return new ResponseEntity<>(interesados, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interesado> getInteresadoById(@PathVariable Long id) {
        try {
            Interesado interesado = interesadoService.findById(id);
            return new ResponseEntity<>(interesado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Interesado> updateInteresado(@PathVariable Long id, @RequestBody Interesado interesado) {
        try {
            Interesado updatedInteresado = interesadoService.update(id, interesado);
            return new ResponseEntity<>(updatedInteresado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInteresado(@PathVariable Long id) {
        try {
            interesadoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
