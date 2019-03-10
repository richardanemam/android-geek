package com.example.capitais.model;

public class CapitalsModel {

   private int thumbnail;
    private String city;

    public CapitalsModel(String city, int thumbnail){
        this.thumbnail = thumbnail;
        this.city = city;
    }

    public int getThumbnail(){
        return this.thumbnail;
    }

    public String getCity(){
        return this.city;
    }
}
