package com.example.NutreAPP.repositories;

import com.example.NutreAPP.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, UUID> {

    // Consultas prefabricadas (Query Methods)
    // 1. El profe pide buscar asociado a un departamento y rol. 
    // Suponiendo que luego agreguen esos campos, se vería así:
    // List<Usuario> findByDepartamentoAndRol(String departamento, String rol);
    
    // Ejemplo real con los campos que ya tenemos:
    List<Usuario> findByNombre(String nombre);
    
    // Buscar por email (útil para login)
    Usuario findByEmail(String email);
}
