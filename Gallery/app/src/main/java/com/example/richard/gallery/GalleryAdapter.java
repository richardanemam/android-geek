package com.example.richard.gallery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Richard on 8/30/2018.
 */

public class GalleryAdapter extends RecyclerView.Adapter {

    private List<Photos> photos;
    private Context context;

    public GalleryAdapter(List<Photos> photos, Context context){
        this.setPhotos(photos);
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.gallery_item, parent, false);

        GalleryHolder galleryHolder = new GalleryHolder(view);

        return galleryHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GalleryHolder galleryViewHolder = (GalleryHolder) holder;

        Picasso.with(context).load(photos.get(position).getPhoto()).resize(250, 250).into(((GalleryHolder) galleryViewHolder).photo_view);
    }

    @Override
    public int getItemCount() {
        return this.getPhotos().size();
    }

    public void setPhotos(List<Photos> photos) {
        this.photos = photos;
    }

    public List<Photos> getPhotos(){
        return this.photos;
    }

    public class GalleryHolder extends RecyclerView.ViewHolder{

        public ImageView photo_view;

        public GalleryHolder(View itemView) {
            super(itemView);
            photo_view = itemView.findViewById(R.id.img);
        }
    }
}
