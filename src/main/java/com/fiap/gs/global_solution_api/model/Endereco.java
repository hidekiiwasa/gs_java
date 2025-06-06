package com.fiap.gs.global_solution_api.model;

public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;

    public String stringificarEndereco(Endereco endereco) {
        return endereco.getLogradouro() + " " + endereco.getNumero() + " "
                + endereco.getComplemento() + " " + endereco.getBairro() + " "
                + endereco.getCidade();
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }
}
