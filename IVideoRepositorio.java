package com.example.NutreAPP.repositories;

import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.models.CategoriaVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IVideoRepositorio extends JpaRepository<Video, UUID> {

    // 1. buscar videos por categoria
    List<Video> findByCategoria(CategoriaVideo categoria);

    // 2. buscar videos por titulo (que ignore mayuscula o minuscula)
    List<Video> findByTituloIgnoreCase(String titulo);

    // 3. buscar un video por descripcion (contenga pedazos)
    List<Video> findByDescripcionContaining(String descripcion);

    // 4. buscar videos por URL
    List<Video> findByUrl(String url);

    // 5. buscar videos por titulo y categoria
    List<Video> findByTituloAndCategoria(String titulo, CategoriaVideo categoria);
}
