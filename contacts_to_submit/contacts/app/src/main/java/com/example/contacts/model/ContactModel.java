package com.example.contacts.model;

public class ContactModel {

    private String nome;
    private String email;
    private String endereço;
    private String telefoneRes;
    private String telefoneCom;

    public ContactModel(String nome, String email, String endereço, String telefoneCom, String telefoneRes){
        this.nome = nome;
        this.email = email;
        this.endereço = endereço;
        this.telefoneCom = telefoneCom;
        this.telefoneRes = telefoneRes;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }

    public String getEndereco(){
        return this.endereço;
    }

    public  String getTelefoneCom(){
        return this.telefoneCom;
    }

    public String getTelefoneRes(){
        return this.telefoneRes;
    }
}
