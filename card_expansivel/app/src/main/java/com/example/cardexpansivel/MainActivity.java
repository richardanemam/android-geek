package com.example.cardexpansivel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private TextView tvTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarViews();
    }

    private void iniciarViews(){
        tvTeste = findViewById(R.id.texto_teste);
        radioGroup = findViewById(R.id.radio);

        addListener();
    }

    private void addListener(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.expande:
                        tvTeste.setVisibility(View.VISIBLE);
                        Animation anim = new AlphaAnimation(0.2f, 1.0f);
                        anim.setDuration(600);
                        tvTeste.startAnimation(anim);
                        break;
                    case R.id.encolhe:
                        tvTeste.setVisibility(View.GONE);
                        break;
                    default:
                }
            }
        });
    }
}
