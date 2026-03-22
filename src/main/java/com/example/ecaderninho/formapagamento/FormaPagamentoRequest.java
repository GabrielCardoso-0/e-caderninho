package com.example.ecaderninho.formapagamento;

public class FormaPagamentoRequest {

    private String descricao;
    private Boolean ativo;

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}