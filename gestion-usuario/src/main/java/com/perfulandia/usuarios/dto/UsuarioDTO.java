package com.perfulandia.usuarios.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Integer idUsuario;
    private String userName;
    private String email;
    private String rol;
    private String estado;
    private LocalDateTime createDate;
    private LocalDateTime lastLogDate;
}
