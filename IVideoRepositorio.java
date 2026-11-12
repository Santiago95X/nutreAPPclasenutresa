package com.example.NutreAPP.repositories;

import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.models.CategoriaVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IVideoRepositorio extends JpaRepository<Video, UUID> {

    // Buscar videos por categoría (SST, TALENTO, etc.)
    List<Video> findByCategoria(CategoriaVideo categoria);

    // Buscar videos cuyo título contenga una palabra
    List<Video> findByTituloContaining(String palabra);
}
