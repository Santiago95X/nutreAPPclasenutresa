package com.example.NutreAPP.repositories;

import com.example.NutreAPP.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, UUID> {

    // Consultas prefabricadas para el Servicio
    List<Usuario> findByDepartamentoAndRol(String departamento, String rol);
    
    Usuario findByEmail(String email);
    
    List<Usuario> findByRol(String rol);
    
    // Para verificar correo (retorna true si existe)
    boolean existsByEmail(String email);
}
