package com.frc.utn.MS_Interesados.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Interesado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo_documento;
    private String documento;
    private String nombre;
    private String apellido;
    private int restringido;
    private int nro_licencia;
    private LocalDate fecha_vencimiento_licencia;

    public Interesado() {
    }

    public Interesado(String tipo_documento, String documento, String nombre, String apellido, int restringido, int nro_licencia, LocalDate fecha_vencimiento_licencia) {
        this.tipo_documento = tipo_documento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.restringido = restringido;
        this.nro_licencia = nro_licencia;
        this.fecha_vencimiento_licencia = fecha_vencimiento_licencia;
    }

    public Long getId() {
        return id;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getRestringido() {
        return restringido;
    }

    public void setRestringido(int restringido) {
        this.restringido = restringido;
    }

    public int getNro_licencia() {
        return nro_licencia;
    }

    public void setNro_licencia(int nro_licencia) {
        this.nro_licencia = nro_licencia;
    }

    public LocalDate getFecha_vencimiento_licencia() {
        return fecha_vencimiento_licencia;
    }

    public void setFecha_vencimiento_licencia(LocalDate fecha_vencimiento_licencia) {
        this.fecha_vencimiento_licencia = fecha_vencimiento_licencia;
    }

    @Override
    public String toString() {
        return "Interesado{" +
                "id=" + id +
                ", tipo_documento='" + tipo_documento + '\'' +
                ", documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", restringido=" + restringido +
                ", nro_licencia=" + nro_licencia +
                ", fecha_vencimiento_licencia=" + fecha_vencimiento_licencia +
                '}';
    }
}
