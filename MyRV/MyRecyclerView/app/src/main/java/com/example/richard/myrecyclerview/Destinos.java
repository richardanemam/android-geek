package com.example.richard.myrecyclerview;

/**
 * Created by Richard on 8/27/2018.
 */

public class Destinos {
    private String pais;
    private String cidade;
    private String photoBy;
    private int foto;

    Destinos(){}
    Destinos(String pais, String cidade, String photoBy, int foto){
        this.setPais(pais);
        this.setCidade(cidade);
        this.setPhotoBy(photoBy);
        this.setFoto(foto);
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public void setPhotoBy(String photoBy) {
        this.photoBy = photoBy;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
    
    public String getPais(){
        return  this.pais;
    }
    
    public String getCidade(){
        return  this.cidade;
    }

    public String getPhotoBy(){
        return  this.photoBy;
    }
    
    public int getFoto(){
        return this.foto;
    }

}
