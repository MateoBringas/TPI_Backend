package com.frc.utn.MS_Vehiculo.Models;

import jakarta.persistence.*;

@Entity
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca id_marca;
    private String descripcion;


    public Modelo() {
    }

    public Modelo(Marca id_marca, String descripcion) {
        this.id_marca = id_marca;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public Marca getId_marca() {
        return id_marca;
    }

    public void setId_marca(Marca id_marca) {
        this.id_marca = id_marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "id=" + id +
                ", id_marca=" + id_marca +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
