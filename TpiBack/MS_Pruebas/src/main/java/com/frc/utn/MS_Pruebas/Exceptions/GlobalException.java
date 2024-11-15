package com.frc.utn.MS_Pruebas.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    // Manejo específico para RestriccionInteresadoException
    @ExceptionHandler(RestriccionInteresadoException.class)
    public ResponseEntity<String> handleRestriccionInteresadoException(RestriccionInteresadoException ex) {
        String message = "El interesado está restringido y no puede realizar la prueba.";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(LicenciaVencidaException.class)
    public ResponseEntity<String> handleLicenciaVencidaException(LicenciaVencidaException ex) {
        String message = "El interesado tiene la licencia vencida y no puede realizar la prueba.";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VehiculoEnUsoException.class)
    public ResponseEntity<String> handleVehiculoEnUsoException(VehiculoEnUsoException ex) {
        String message = "El vehiculo esta en uso.";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
