package com.example.ecaderninho.usuario;

public class UsuarioResponse {

    private Long id;
    private String nome;
    private String email;
    private String estabelecimento;

    // GETTERS

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    // SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
}