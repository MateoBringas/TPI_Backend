package com.frc.utn.MS_Empleados.Controllers;



import com.frc.utn.MS_Empleados.Models.Empleado;
import com.frc.utn.MS_Empleados.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<Empleado> createMarca(@RequestBody Empleado empleado) {
        try {
            Empleado createdEmpleado= empleadoService.save(empleado);
            return new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        try {
            List<Empleado> empleados = empleadoService.findAll();
            return new ResponseEntity<>(empleados, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{legajo}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long legajo) {
        try {
            Empleado empleado = empleadoService.findById(legajo);
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{legajo}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable Long legajo, @RequestBody Empleado marca) {
        try {
            Empleado updatedEmpleado = empleadoService.update(legajo, marca);
            return new ResponseEntity<>(updatedEmpleado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{legajo}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long legajo) {
        try {
            empleadoService.delete(legajo);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

