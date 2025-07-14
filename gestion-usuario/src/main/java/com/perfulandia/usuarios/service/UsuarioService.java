package com.perfulandia.usuarios.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.perfulandia.usuarios.config.UsuarioMapper;
import com.perfulandia.usuarios.dto.CrearUsuarioRequest;
import com.perfulandia.usuarios.dto.UsuarioDTO;
import com.perfulandia.usuarios.model.Cliente;
import com.perfulandia.usuarios.model.Usuario;
import com.perfulandia.usuarios.model.Vendedor;
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
                u.getEstado()
            )).toList();
    }

    public Usuario crearUsuario(CrearUsuarioRequest usrReq){
        
        Usuario u = new Usuario();

        u.setUserName(usrReq.getNombreUsuario());
        u.setEmail(usrReq.getEmail());

        // System.out.println("DEBUG >> contrasena: " + usrReq.getContrasena());
        // System.out.println(usrReq);


        // ✅ Validar que la contraseña no sea nula ni vacía
        String rawPassword = usrReq.getContrasena();
        if (rawPassword == null || rawPassword.isBlank()) {
            throw new IllegalArgumentException("La clave es requerida");
        }

        // codifica contraseña
        u.setPws(pwsEncoder.encode(rawPassword));

        u.setRol(usrReq.getRol());
        u.setEstado(usrReq.getEstado());

        // guarda usuario
        Usuario nuevoUsuario = usuarioRepo.save(u);

        switch (usrReq.getRol().toLowerCase()) {

            case "cliente" -> {
                Cliente c = new Cliente();

                c.setIdCliente(null);

                c.setUsuario(nuevoUsuario);
                c.setNombreCompleto(usrReq.getNombreCompleto());
                c.setRut(usrReq.getRut());
                c.setDireccion(usrReq.getDireccion());
                c.setTelefono(usrReq.getTelefono());

                clienteRepo.save(c);
            }

            case "vendedor" -> {
                Vendedor v = new Vendedor();

                v.setIdVendedor(null);
                
                v.setUsuario(nuevoUsuario);
                v.setNombreCompleto(usrReq.getNombreCompleto());
                v.setRut(usrReq.getRut());
                v.setAreaVentas(usrReq.getAreaVentas());

                vendedorRepo.save(v);
            }

            case "admin" -> {
                // No se necesita nada extra, solo se guarda como usuario
            }

            default -> throw new IllegalArgumentException("Rol no soportado: " + usrReq.getRol());
        }

        return nuevoUsuario;
    }

    public UsuarioDTO buscarUsuarioPorId(Integer id) {
        Usuario usuario = 
            usuarioRepo
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id))
        ;

        // Convertir Usuario a UsuarioDTO
        return mapper.usuarioToDto(usuario);
    }

    public UsuarioDTO actualizarUsuario(Integer id, UsuarioDTO dto) {
        Usuario usuario = 
            usuarioRepo
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id))
        ;

        usuario.setUserName(dto.getNombreUsuario());
        usuario.setEmail(dto.getEmail());
        usuario.setEstado(dto.getEstado());
        usuario.setRol(dto.getRol());

        Usuario guardado = usuarioRepo.save(usuario);

        return mapper.usuarioToDto(guardado);
    }


    public void eliminarUsuario(Integer id) {
        usuarioRepo.deleteById(id);
    }
}
