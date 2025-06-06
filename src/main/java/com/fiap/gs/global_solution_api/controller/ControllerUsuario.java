package com.fiap.gs.global_solution_api.controller;

import com.fiap.gs.global_solution_api.dto.UsuarioRequestCreate;
import com.fiap.gs.global_solution_api.dto.UsuarioRequestUpdate;
import com.fiap.gs.global_solution_api.dto.UsuarioResponse;
import com.fiap.gs.global_solution_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("usuarios")
public class ControllerUsuario {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody UsuarioRequestCreate dto) {
        return ResponseEntity.status(201).body(new UsuarioResponse().toDto(usuarioService.saveUsuario(dto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<UsuarioResponse> update(@PathVariable Long id, @RequestBody UsuarioRequestUpdate dto) {
        return usuarioService.update(id, dto)
                .map(usuario -> {
                    return ResponseEntity.status(200).body(new UsuarioResponse().toDto(usuario));
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll() {
        return ResponseEntity.ok(usuarioService.findAllUsuarios().stream()
                .map(usuario -> {
                    return new UsuarioResponse().toDto(usuario);
                }).collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable Long id) {
        return usuarioService.findById(id)
                .map(usuario -> {
                    return ResponseEntity.status(200).body(new UsuarioResponse().toDto(usuario));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        boolean result = usuarioService.deleteById(id);

        if (result) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
