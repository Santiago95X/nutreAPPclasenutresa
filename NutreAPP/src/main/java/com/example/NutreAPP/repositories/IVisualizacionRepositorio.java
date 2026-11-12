package com.example.NutreAPP.repositories;

import com.example.NutreAPP.models.Visualizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface IVisualizacionRepositorio extends JpaRepository<Visualizacion, UUID> {

    List<Visualizacion> findByFechaVisualizacion(LocalDate fechaVisualizacion);
    List<Visualizacion> findByCompletadoFalse();
    List<Visualizacion> findByCompletadoTrue();
}
