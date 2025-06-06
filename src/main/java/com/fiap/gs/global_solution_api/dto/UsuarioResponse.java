package com.fiap.gs.global_solution_api.dto;

import com.fiap.gs.global_solution_api.model.Usuario;

public class UsuarioResponse {
    private String nome;
    private String username;
    private String senha;

    public UsuarioResponse toDto(Usuario usuario) {
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setNome(usuario.getNome());
        usuarioResponse.setUsername(usuario.getUsername());
        usuarioResponse.setSenha(usuario.getSenha());

        return usuarioResponse;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
