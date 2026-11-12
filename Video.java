package com.example.NutreAPP.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name = "videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String titulo;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false)
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaVideo categoria;

    // RELACIÓN BIDIRECCIONAL CON VISUALIZACION
    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL)
    private List<Visualizacion> visualizaciones = new ArrayList<>();

    public Video() {
    }

    // Getters y Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public CategoriaVideo getCategoria() { return categoria; }
    public void setCategoria(CategoriaVideo categoria) { this.categoria = categoria; }

    public List<Visualizacion> getVisualizaciones() { return visualizaciones; }
    public void setVisualizaciones(List<Visualizacion> visualizaciones) { this.visualizaciones = visualizaciones; }
}
