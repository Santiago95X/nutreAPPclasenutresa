package com.example.NutreAPP.models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity 
@Table(name="visualizaciones")
public class Visualizacion {

    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "fechaVisualizacion", nullable = false, unique = false) 
    private LocalDate fechaVisualizacion;

    @Column(name = "completado", nullable = false, unique = false)
    private Boolean completado;

    public Visualizacion() {
    }

    public Visualizacion(UUID id, LocalDate fechaVisualizacion, Boolean completado) {
        this.id = id;
        this.fechaVisualizacion = fechaVisualizacion;
        this.completado = completado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getFecha_visualizacion() {
        return fechaVisualizacion;
    }

    public void setFecha_visualizacion(LocalDate fechaVisualizacion) {
        this.fechaVisualizacion = fechaVisualizacion;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }

    

    

}
