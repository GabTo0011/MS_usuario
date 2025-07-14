package com.perfulandia.usuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Column;

// import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")

@Data // Getters /Setters
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    
    @Column(name = "nombre_usuario")
    private String userName;
    private String email;
    
    @Column(name = "contrasena")
    private String pws;
    private String rol;
    private String estado;

    // @Column(name = "create_date")
    // private LocalDateTime createDate = LocalDateTime.now();
    
    // @Column(name = "last_log_date")
    // private LocalDateTime lastLogDate = LocalDateTime.now();
}

