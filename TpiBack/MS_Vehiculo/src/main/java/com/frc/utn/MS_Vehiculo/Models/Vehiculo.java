package com.frc.utn.MS_Vehiculo.Models;

import jakarta.persistence.*;

@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    @ManyToOne
    private Modelo modelo;

    public Vehiculo() {
    }

    public Vehiculo(String patente, Modelo modelo) {
        this.patente = patente;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", patente='" + patente + '\'' +
                ", modelo=" + modelo +
                '}';
    }
}
