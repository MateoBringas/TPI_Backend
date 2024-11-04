package com.frc.utn.MS_Vehiculo.Models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Modelo> modelos;

    public Marca() {
    }

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
