package com.example.carousel;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarViews();
    }

    private void inicializarViews(){
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(4);
        CarouselAdapter adapter = new CarouselAdapter(getSupportFragmentManager());

        CarouselFragment carouselA = CarouselFragment.newInstance(R.drawable.r1);
        adapter.addFragment(carouselA);

        CarouselFragment carouselB = CarouselFragment.newInstance(R.drawable.r2);
        adapter.addFragment(carouselB);

        CarouselFragment carouselC = CarouselFragment.newInstance(R.drawable.r3);
        adapter.addFragment(carouselC);

        CarouselFragment carouselD = CarouselFragment.newInstance(R.drawable.r4);
        adapter.addFragment(carouselD);

        viewPager.setAdapter(adapter);

    }

}
