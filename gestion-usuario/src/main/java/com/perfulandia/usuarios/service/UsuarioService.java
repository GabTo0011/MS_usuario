package com.perfulandia.usuarios.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.perfulandia.usuarios.config.UsuarioMapper;
import com.perfulandia.usuarios.dto.CreateUsuarioRequest;
import com.perfulandia.usuarios.dto.UsuarioDTO;
import com.perfulandia.usuarios.model.Usuario;
import com.perfulandia.usuarios.repository.ClienteRepository;
import com.perfulandia.usuarios.repository.UsuarioRepository;
import com.perfulandia.usuarios.repository.VendedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepo;
    private final ClienteRepository clienteRepo;
    private final VendedorRepository vendedorRepo;

    private final PasswordEncoder pwsEncoder;
    private final UsuarioMapper mapper;

    public List<UsuarioDTO> listarUsuarios(){
        return usuarioRepo.findAll().stream().map(
            u -> new UsuarioDTO(
                u.getIdUsuario(),
                u.getUserName(),
                u.getEmail(),
                u.getRol(),
                u.getEstado(),
                u.getCreateDate(),
                u.getLastLogDate()
            )).toList();
    }

    public Usuario crearUsuario(CreateUsuarioRequest usrReq){
        Usuario u = new Usuario();

        u.setUserName(usrReq.getUserName());
        u.setEmail(usrReq.getEmail());

        String rawPassword = usrReq.getPws();

        if(rawPassword == null || rawPassword.trim().isEmpty()){
            throw new IllegalArgumentException("La clave es requerida")
        }
    }
}
