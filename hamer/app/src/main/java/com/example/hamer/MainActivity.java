package com.example.hamer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private HandlerThread handlerThread = new HandlerThread("HandlreThread");
    private Handler threadHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handlerThread.start();

        handlerThread.start();
        threadHandler = new Handler(handlerThread.getLooper());
    }


    public void doWork(View view) {

    }

    public void removeMessages(View view) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThread.quit();
    }
}
