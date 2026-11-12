package com.example.NutreAPP.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    // RELACIÓN BIDIRECCIONAL CON VISUALIZACION
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Visualizacion> visualizaciones = new ArrayList<>();

    public Usuario() {
    }

    // Getters y Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Visualizacion> getVisualizaciones() { return visualizaciones; }
    public void setVisualizaciones(List<Visualizacion> visualizaciones) { this.visualizaciones = visualizaciones; }
}
