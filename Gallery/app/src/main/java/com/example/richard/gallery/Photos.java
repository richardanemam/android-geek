package com.example.richard.gallery;

/**
 * Created by Richard on 8/30/2018.
 */

public class Photos {
    private int photo;
    Photos(int photo){
        this.setPhoto(photo);
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getPhoto(){
        return this.photo;
    }
}
