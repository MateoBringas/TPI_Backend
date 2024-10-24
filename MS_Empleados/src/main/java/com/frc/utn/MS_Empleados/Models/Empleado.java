package com.frc.utn.MS_Empleados.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long legajo;
    private String nombre;
    private String apellido;
    private int telefono_Contacto;

    public Empleado() {
    }

    public Empleado(int telefono_Contacto, String apellido, String nombre) {
        this.telefono_Contacto = telefono_Contacto;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public int getTelefono_Contacto() {
        return telefono_Contacto;
    }

    public void setTelefono_Contacto(int telefono_Contacto) {
        this.telefono_Contacto = telefono_Contacto;
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
                ", telefono_Contacto=" + telefono_Contacto +
                '}';
    }
}
