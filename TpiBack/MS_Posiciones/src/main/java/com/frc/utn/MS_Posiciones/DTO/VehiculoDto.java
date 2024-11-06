package com.frc.utn.MS_Posiciones.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)  // Evitar que valores nulos sean serializados
public class VehiculoDto {
    private Long id;
    private String patente;
    private ModeloDto id_modelo;  // Asegúrate de que esto sea un DTO que representa el modelo del vehículo

    // Getters
    public Long getId() {
        return id;
    }

    public String getPatente() {
        return patente;
    }

    public ModeloDto getId_modelo() {
        return id_modelo;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setId_modelo(ModeloDto id_modelo) {
        this.id_modelo = id_modelo;
    }
}
