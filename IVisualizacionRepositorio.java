package com.example.NutreAPP.repositories;

import com.example.NutreAPP.models.Visualizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface IVisualizacionRepositorio extends JpaRepository<Visualizacion, UUID> {

    // 1. buscar visualizaciones por fecha de visualizacion
    // OJO: El atributo en el modelo debe llamarse 'fechaVisualizacion' (sin guion bajo) para que esto funcione.
    List<Visualizacion> findByFechaVisualizacion(LocalDate fechaVisualizacion);

    // 2. buscar visualizaciones sin completar (equivale a completado = false)
    List<Visualizacion> findByCompletadoFalse();

    // 3. buscar visualizaciones completadas (equivale a completado = true)
    List<Visualizacion> findByCompletadoTrue();
}
