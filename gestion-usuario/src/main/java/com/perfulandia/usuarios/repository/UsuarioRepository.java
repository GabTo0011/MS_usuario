package com.perfulandia.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.usuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

}
