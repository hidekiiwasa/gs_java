package com.fiap.gs.global_solution_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fiap.gs.global_solution_api.enums.StatusEvento;
import com.fiap.gs.global_solution_api.model.Evento;

import java.time.Duration;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventoRequestGet {
    private String nomeUsuario;
    private String endereco;
    private String cep;
    private String regiao;
    private String estado;
    private String causa;
    private String descricao;
    private StatusEvento status;
    private LocalDateTime quandoComecou;
    private String duracao;

    public EventoRequestGet toDto(Evento evento) {
        this.setNomeUsuario(evento.getUsuario().getNome());
        this.setEndereco(evento.getEndereco());
        this.setCep(evento.getCep());
        this.setRegiao(evento.getRegiao());
        this.setEstado(evento.getEstado());
        this.setCausa(evento.getCausa());
        this.setDescricao(evento.getDescricao());
        this.setStatus(evento.getStatus());
        this.setQuandoComecou(evento.getQuandoComecou());
        if (!StatusEvento.ENCERRADO.equals(evento.getStatus())) {
            this.setDuracao(formatarDuracao(Duration.between(evento.getQuandoComecou(), LocalDateTime.now())));
        } else {
            this.setDuracao(null);
        }
        return this;
    }

    private String formatarDuracao(Duration duracao) {
        long dias = duracao.toDays();
        long horas = duracao.toHours() % 24;
        long minutos = duracao.toMinutes() % 60;

        StringBuilder sb = new StringBuilder();
        if (dias > 0) sb.append(dias).append(dias == 1 ? " dia, " : " dias, ");
        if (horas > 0) sb.append(horas).append(horas == 1 ? " hora, " : " horas, ");
        if (minutos > 0) sb.append(minutos).append(minutos == 1 ? " minuto" : " minutos");

        if (sb.toString().endsWith(", ")) {
            sb.setLength(sb.length() - 2);
        }

        return sb.toString();
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

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}