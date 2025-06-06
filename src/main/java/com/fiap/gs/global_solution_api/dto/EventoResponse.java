package com.fiap.gs.global_solution_api.dto;

import com.fiap.gs.global_solution_api.enums.StatusEvento;
import com.fiap.gs.global_solution_api.model.Evento;

import java.time.LocalDateTime;

public class EventoResponse {
    private String nomeUsuario;
    private String endereco;
    private String cep;
    private String regiao;
    private String estado;
    private String causa;
    private String descricao;
    private StatusEvento status;
    private LocalDateTime quandoComecou;

    public EventoResponse toDto(Evento evento) {
        this.setNomeUsuario(evento.getUsuario().getNome());
        this.setEndereco(evento.getEndereco());
        this.setCep(evento.getCep());
        this.setRegiao(evento.getRegiao());
        this.setEstado(evento.getEstado());
        this.setCausa(evento.getCausa());
        this.setDescricao(evento.getDescricao());
        this.setStatus(evento.getStatus());
        this.setQuandoComecou(evento.getQuandoComecou());

        return this;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusEvento getStatus() {
        return status;
    }

    public void setStatus(StatusEvento status) {
        this.status = status;
    }

    public LocalDateTime getQuandoComecou() {
        return quandoComecou;
    }

    public void setQuandoComecou(LocalDateTime quandoComecou) {
        this.quandoComecou = quandoComecou;
    }
}
