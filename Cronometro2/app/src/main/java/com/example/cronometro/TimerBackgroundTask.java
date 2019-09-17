package com.example.cronometro;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public class TimerBackgroundTask extends HandlerThread {

    private long timeElapsed;
    private boolean running;
    private Handler uiHandler;

    private static final long TIMER_SPEED = 1000;
    public static final int START_MESSAGE = 0;
    public static final int STOP_MESSAGE = 1;
    public static final int RESET_MESSAGE = 2;

    public TimerBackgroundTask(String name, Handler uiHandler) {
        super(name);
        running = false;
        this.uiHandler = uiHandler;
    }

    public TimerBackgroundTask(String name, int priority, Handler uiHandler, long startTime) {
        this(name, uiHandler);
        this.timeElapsed = startTime;
    }

    private class TimerBackgroundTaskHandler implements Handler.Callback {

        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    startTimer();
                    return true;
                case 1:
                    stopTimer();
                    return true;
                case 2:
                    resetTimer();
                    return true;
                default:
                    return false;
            }
        }
    }

    private void startTimer() {
    }

    private void stopTimer() {
    }

    private void resetTimer() {
    }
}
