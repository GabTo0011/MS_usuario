package com.perfulandia.usuarios.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

// datos requeridos para crear el usuario
@Data
public class CreateUsuarioRequest {
    
    // datos de usuario
    private String userName;
    private String email;

    @JsonProperty("contrasena")
    private String pws;

    private String rol;
    private String estado;

    // datos de cliente y vendedor
    private String nombre;
    private String apellido;
    private String rut;

    // datos solo cliente
    private String telefono;
    private String direccion;
    private String comuna;

    // datos solo vendedor
    private String sucursal;
    private String areaVenta;

}
