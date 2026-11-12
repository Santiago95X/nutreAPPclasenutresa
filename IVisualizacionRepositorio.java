package com.example.NutreAPP.repositories;

import com.example.NutreAPP.models.Visualizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IVisualizacionRepositorio extends JpaRepository<Visualizacion, UUID> {

    // Buscar todas las visualizaciones de un usuario específico
    List<Visualizacion> findByUsuarioId(UUID usuarioId);

    // Buscar todas las visualizaciones de un video específico
    List<Visualizacion> findByVideoId(UUID videoId);
}
