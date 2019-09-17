package com.example.hamer;

import android.os.Handler;
import android.os.Looper;

public class LooperThread extends Thread {
    private static final String TAG = "LooperThread";

    @Override
    public void run() {
        Looper.prepare(); //Creates a message queue
        Handler handler = new Handler();
        Looper.loop(); //Starts the associated loop
    }
}
