package com.frc.utn.MS_Posiciones.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int idVehiculo;
    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;
    private Double latitud;
    private Double longitud;


}
