package com.example.NutreAPP.repositories;

import com.example.NutreAPP.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, UUID> {

    List<Usuario> findByNombre(String nombre);
    Usuario findByEmail(String email);
}
