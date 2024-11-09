package com.frc.utn.MS_Empleados.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long legajo;
    private String nombre;
    private String apellido;
    @Column(name = "telefono_contacto")
    private int telefonoContacto;
}
