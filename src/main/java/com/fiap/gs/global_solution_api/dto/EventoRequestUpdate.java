package com.fiap.gs.global_solution_api.dto;

import com.fiap.gs.global_solution_api.enums.StatusEvento;
import com.fiap.gs.global_solution_api.model.Endereco;

import java.time.LocalDate;

public class EventoRequestUpdate {
    private Endereco endereco;
    private String cep;
    private String regiao;
    private String estado;
    private String causa;
    private String descricao;
    private StatusEvento status;

    public Endereco getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getEstado() {
        return estado;
    }

    public String getCausa() {
        return causa;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusEvento getStatus() {
        return status;
    }
}
