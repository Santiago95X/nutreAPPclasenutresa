package com.example.NutreAPP.services;

import com.example.NutreAPP.repositories.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

    // Inyección del repositorio para poder usar sus métodos (guardar, buscar, etc.)
    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;

    //metodo para guardar

    //metodo para buscar por id

    //metodo para buscar todos

    //metodo para modificar

    //metodo para eliminar

    //metodo para buscar por depto y rol

    //metodo para buscar por correo

    //metodo para buscar por rol

    //metodo para verificar correo
}
