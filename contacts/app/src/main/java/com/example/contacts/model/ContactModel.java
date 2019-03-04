package com.example.contacts.model;

public class ContactModel {

    private String nome;
    private String email;

    public ContactModel(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }
}
