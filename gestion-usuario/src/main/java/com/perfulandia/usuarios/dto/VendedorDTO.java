package com.perfulandia.usuarios.dto;

import com.perfulandia.usuarios.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedorDTO {

    private Integer idVendedor;
    private Usuario idUsuario;
    
    private String nombre;
    private String apellido;
    private String rut;
    private String sucursal;
    private String areaVenta;
}
