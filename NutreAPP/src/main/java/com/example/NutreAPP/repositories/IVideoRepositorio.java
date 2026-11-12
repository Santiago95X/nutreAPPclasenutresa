package com.example.NutreAPP.repositories;

import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.models.CategoriaVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IVideoRepositorio extends JpaRepository<Video, UUID> {

    List<Video> findByCategoria(CategoriaVideo categoria);
    List<Video> findByTituloIgnoreCase(String titulo);
    List<Video> findByDescripcionContaining(String descripcion);
    List<Video> findByUrl(String url);
    List<Video> findByTituloAndCategoria(String titulo, CategoriaVideo categoria);
}
