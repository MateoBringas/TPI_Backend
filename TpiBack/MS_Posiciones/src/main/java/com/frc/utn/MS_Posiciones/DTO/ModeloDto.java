package com.frc.utn.MS_Posiciones.DTO;

public class ModeloDto {
    private Long id;
    private MarcaDto id_marca;  // Relación con la marca del modelo
    private String descripcion;

    // Getters
    public Long getId() {
        return id;
    }

    public MarcaDto getId_marca() {
        return id_marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setId_marca(MarcaDto id_marca) {
        this.id_marca = id_marca;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
