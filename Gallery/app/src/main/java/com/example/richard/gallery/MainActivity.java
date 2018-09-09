package com.example.richard.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView gallery_recycler = findViewById(R.id.recycler);
        gallery_recycler.hasFixedSize();

        RecyclerView.LayoutManager gallery_layout = new GridLayoutManager(getApplicationContext(), 3);
        gallery_recycler.setLayoutManager(gallery_layout);

        List<Photos> setOfPhotos = galleryPhotos();
        gallery_recycler.setAdapter(new GalleryAdapter(setOfPhotos, this));
    }

    public List<Photos> galleryPhotos(){
        int photos[] = {R.drawable.aurora_kreativ_miami, R.drawable.bundo_kim, R.drawable.cerqueira_rj, R.drawable.finan_akbar,
                        R.drawable.mike_chavarri_nyc, R.drawable.raj_eiamworakul_beijing, R.drawable.robert_tudor, R.drawable.sergio_souza_sp,
                        R.drawable.stefan_widua, R.drawable.usukhbayar_gankhuyag_shanghai, R.drawable.yiran_ding};

        List<Photos> setOfPhotos = new ArrayList<>();

        for(int i = 0; i < photos.length; i++){
            Photos setPhoto = new Photos(photos[i]);
            setOfPhotos.add(setPhoto);
        }

        return setOfPhotos;
    }
}
