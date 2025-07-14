package com.perfulandia.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.usuarios.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor,Integer>{

}