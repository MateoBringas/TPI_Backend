package com.frc.utn.MS_Empleados.Models;

import jakarta.persistence.*;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long legajo;
    private String nombre;
    private String apellido;
    @Column(name = "telefono_contacto")
    private int telefonoContacto;

    public Empleado() {
    }

    public Empleado(int telefonoContacto, String apellido, String nombre) {
        this.telefonoContacto = telefonoContacto;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public int getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(int telefono_Contacto) {
        this.telefonoContacto = telefono_Contacto;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getLegajo() {
        return legajo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "legajo=" + legajo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono_Contacto=" + telefonoContacto +
                '}';
    }
}
