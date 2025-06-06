package com.fiap.gs.global_solution_api.service;

import com.fiap.gs.global_solution_api.dto.UsuarioRequestCreate;
import com.fiap.gs.global_solution_api.dto.UsuarioRequestUpdate;
import com.fiap.gs.global_solution_api.model.Usuario;
import com.fiap.gs.global_solution_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario saveUsuario(UsuarioRequestCreate dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setUsername(dto.getUsername());
        usuario.setSenha(dto.getSenha());

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> update(Long id, UsuarioRequestUpdate dto) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(dto.getNome());
                    usuario.setUsername(dto.getUsername());
                    usuario.setSenha(dto.getSenha());
                    return usuarioRepository.save(usuario);
                });
    }

    public boolean deleteById(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
