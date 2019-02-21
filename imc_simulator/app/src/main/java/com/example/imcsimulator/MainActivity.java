package com.example.imcsimulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView pesoKg;
    private TextView alturaCm;
    private TextView imc;
    private TextView imcStatus;
    private SeekBar pesoSeek;
    private SeekBar alturaSeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startViews();
        bindSeekbarHandlers();
        init();
    }

    private void startViews() {
        pesoKg = findViewById(R.id.peso_kg);
        alturaCm = findViewById(R.id.altura_cm);
        imc = findViewById(R.id.imc);
        imcStatus = findViewById(R.id.imc_status);
        pesoSeek = findViewById(R.id.peso_seek);
        alturaSeek = findViewById(R.id.altura_seek);
    }

    private void init() {
        alturaSeek.setProgress(170);
        pesoSeek.setProgress(60);
    }

    public void updateImc() {
        double peso = pesoSeek.getProgress();
        double altura = alturaSeek.getProgress() / 100.0;

        double imcValue = 0.0;

        if (altura > 0.0)
            imcValue = peso / (altura * altura);

        imc.setText(String.format("%.2f", imcValue));
        updateStatus(imcValue);
    }

    private void updateStatus(double imcValue) {
        if(imcValue >= 16.0 && imcValue < 16.9){
            imcStatus.setText(R.string.muito_abaixo);
        }
        else if(imcValue >= 17.0 && imcValue < 18.4){
            imcStatus.setText(R.string.abaixo);
        }
        else if(imcValue >= 18.5 && imcValue < 24.9){
            imcStatus.setText(R.string.normal);
        }
        else if(imcValue >= 25.0 && imcValue < 29.9){
            imcStatus.setText(R.string.obesidade_um);
        }
        else if(imcValue >= 35.0 && imcValue < 40.0){
            imcStatus.setText(R.string.obesidade_dois);
        }
        else{
            imcStatus.setText(R.string.obesidade_tres);
        }
    }

    public void updatePeso(int progress) {
        pesoKg.setText(progress + " kg");
        updateImc();
    }

    public void updateAltura(int progress) {
        alturaCm.setText(progress / 100.0 + " m");
        updateImc();
    }

    private void bindSeekbarHandlers() {
        pesoSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updatePeso(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        alturaSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateAltura(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}