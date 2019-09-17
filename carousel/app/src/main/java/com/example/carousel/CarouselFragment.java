package com.example.carousel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CarouselFragment extends Fragment {

    private static final String IMAGE = "image";

    private int image;
    private ImageView ivImage;

    public static CarouselFragment newInstance(int image){
        CarouselFragment carouselFragment = new CarouselFragment();
        Bundle extras = new Bundle();
        extras.putInt(IMAGE, image);
        carouselFragment.setArguments(extras);

        return carouselFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.item_carousel, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeViews(getArguments());
    }

    private void initializeViews(Bundle extras){
        image = extras.getInt(IMAGE);
        ivImage = getView().findViewById(R.id.iv_container);
        ivImage.setImageResource(image);
    }
}
