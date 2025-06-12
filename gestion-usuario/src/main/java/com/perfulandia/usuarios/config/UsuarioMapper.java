package com.perfulandia.usuarios.config;

import org.springframework.stereotype.Component;

import com.perfulandia.usuarios.dto.UsuarioDTO;
import com.perfulandia.usuarios.model.Usuario;

@Component
public class UsuarioMapper {
    
    public UsuarioDTO usuarioToDto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setUserName(usuario.getUserName());
        dto.setEmail(usuario.getEmail());
        dto.setRol(usuario.getRol());
        dto.setEstado(usuario.getEstado());
        dto.setCreateDate(usuario.getCreateDate());
        dto.setLastLogDate(usuario.getLastLogDate());
        
        return dto;
    }
}