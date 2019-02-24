package com.example.btucalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView areaM;
    private TextView qtdPessoas;
    private TextView btu;
    private SeekBar areaSeek;
    private SeekBar pessoasSeek;
    private int btuValue = 0;

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
        areaM = findViewById(R.id.area_metro_quadrado);
        qtdPessoas = findViewById(R.id.quantidade_pessoas);
        btu = findViewById(R.id.btu);
        areaSeek = findViewById(R.id.area_seek);
        pessoasSeek = findViewById(R.id.people_seek);
    }

    private void init() {
        pessoasSeek.setProgress(170);
        areaSeek.setProgress(60);
    }

    private void updateBtu() {
        btu.setText(getString(R.string.btu_value, btuValue));
    }

    private void updateArea(int progress) {
        areaM.setText(getString(R.string.progress_area, progress));
    }

    private void updatePeople(int progress) {
        qtdPessoas.setText(getString(R.string.progress_people, progress));
    }

    private void bindSeekbarHandlers() {
        areaSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateArea(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        pessoasSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updatePeople(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void onCheckboxClicked(View view) {
        int area = areaSeek.getProgress();
        int pessoas = pessoasSeek.getProgress() - 1;
        boolean checked = ((RadioButton) view).isChecked();

        if (pessoas > 0 && area > 0) {
            switch (view.getId()) {
                case R.id.rb_six_hundred:
                    if (checked)
                        btuValue = 600 * (area * pessoas);
                    updateBtu();
                    break;
                case R.id.rb_nine_hundred:
                    if (checked)
                        btuValue = 900 * (area * pessoas);
                    updateBtu();
                    break;
            }
        } else {
            Toast.makeText(this, getString(R.string.definir_valores),
                    Toast.LENGTH_SHORT).show();
        }
    }
}

