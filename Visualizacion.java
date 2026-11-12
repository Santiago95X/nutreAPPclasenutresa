package com.example.NutreAPP.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "visualizaciones")
public class Visualizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "fecha_visualizacion", nullable = false)
    private LocalDate fecha_visualizacion;

    @Column(name = "completado", nullable = false)
    private Boolean completado;

    // RELACIÓN CON USUARIO (N a 1)
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // RELACIÓN CON VIDEO (N a 1)
    @ManyToOne
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    public Visualizacion() {
    }

    public Visualizacion(LocalDate fecha_visualizacion, Boolean completado, Usuario usuario, Video video) {
        this.fecha_visualizacion = fecha_visualizacion;
        this.completado = completado;
        this.usuario = usuario;
        this.video = video;
    }

    // Getters y Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public LocalDate getFecha_visualizacion() { return fecha_visualizacion; }
    public void setFecha_visualizacion(LocalDate fecha_visualizacion) { this.fecha_visualizacion = fecha_visualizacion; }

    public Boolean getCompletado() { return completado; }
    public void setCompletado(Boolean completado) { this.completado = completado; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Video getVideo() { return video; }
    public void setVideo(Video video) { this.video = video; }
}
