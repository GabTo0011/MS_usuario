package com.perfulandia.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.usuarios.model.Cliente;

public interface VendedorRepository extends JpaRepository<Cliente,Integer>{

}