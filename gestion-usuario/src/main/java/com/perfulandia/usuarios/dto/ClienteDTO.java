package com.perfulandia.usuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Integer idCliente;
    private Integer idUsuario;
    
    private String nombre;
    private String apellido;
    private String rut;
    private String direccion;
    private String comuna;
    private String telefono;
}