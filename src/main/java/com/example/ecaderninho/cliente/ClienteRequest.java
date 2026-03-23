package com.example.ecaderninho.cliente;

public class ClienteRequest {

    private Long idUsuario;
    private String nome;
    private String cpf;
    private String contato;

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    
    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }
}