package com.example.contacts.model;

public class ContactModel {

    private String nome;
    private String email;
    private String endereco;
    private String telefoneRes;
    private String telefoneCom;

    public ContactModel(String nome, String email, String endereco, String telefoneCom, String telefoneRes) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefoneCom = telefoneCom;
        this.telefoneRes = telefoneRes;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getTelefoneCom() {
        return this.telefoneCom;
    }

    public String getTelefoneRes() {
        return this.telefoneRes;
    }
}
