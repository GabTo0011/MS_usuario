package com.perfulandia.usuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


import jakarta.persistence.Column;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;
    
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    private String nombreCompleto;
    private String rut;
    private String telefono;
    private String direccion;

    // private String comuna;

}


