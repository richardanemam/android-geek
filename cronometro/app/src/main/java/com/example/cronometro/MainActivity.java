package com.example.cronometro;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button startStopBtn;
    private Button resetBtn;
    private TextView elapsedTimeText;

    private long elapsedTime;
    private final static long TIMER_SPEED = 1000;
    final Handler handler = new Handler();
    final Runnable timer = new Runnable(){
        @Override
        public void run() {
            elapsedTime++;
            updateTime();
            handler.postDelayed(this, TIMER_SPEED);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onStart() {
        super.onStart();
        bindComponents();
        reset();
        toggleStartStop();
        startResetButton();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("elapsedTime", elapsedTime);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        elapsedTime = savedInstanceState.getLong("elapsedTime");
    }

    private void bindComponents(){
        elapsedTimeText = findViewById(R.id.tv_elapsed_time);
        startStopBtn = findViewById(R.id.button_start_stop);
        resetBtn = findViewById(R.id.button_reset);
    }

    private void reset(){
        elapsedTime = 0;
        updateTime();
        //runTimer();
    }

    private void updateTime(){
        long hours = elapsedTime/3600;
        long minutes = elapsedTime % 3600 / 60;
        long seconds = elapsedTime % 60;
        elapsedTimeText.setText((String.format("%02d:%02d:%02d", hours, minutes, seconds)));
    }

    private void toggleStartStop(){
        startStopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(startStopBtn.getText().equals("start")) {
                    // updateTime();
                    //runTimer();
                    handler.postDelayed(timer, 0);
                    startStopBtn.setText(R.string.btn_stop);
                } else {
                    handler.removeCallbacks(timer);
                    startStopBtn.setText(R.string.btn_start);
                }
            }
        });
    }

    private void startResetButton(){
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                elapsedTimeText.setText(R.string.init_time);
                handler.removeCallbacks(timer);
                startStopBtn.setText(R.string.btn_start);
            }
        });
    }
}
