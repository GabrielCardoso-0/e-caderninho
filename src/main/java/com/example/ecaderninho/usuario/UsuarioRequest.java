package com.example.ecaderninho.usuario;

public class UsuarioRequest {

    private String nome;
    private String email;
    private String estabelecimento;
    private String senha;

    // getters e setters
    public String getNome() {
        return nome;
    };
    public String getEmail() {
        return email;
    };
    public String getEstabelecimento() {
        return estabelecimento;
    };
    public String getSenha(){
        return senha;
    };

    public void setNome(String nome) {
        this.nome =nome;
    };
    public void setEmail(String email) {
        this.email =email;
    };
    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento =estabelecimento;
    };
    public void setSenha(String senha) {
        this.senha =senha;
    };
    
}