package com.example.richard.alertdialog.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.richard.alertdialog.R;
import com.example.richard.alertdialog.fragment.GotItDialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButtonView();

    }

    private void startButtonView() {
        Button btnShowDialog = findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GotItDialogFragment gotIt = GotItDialogFragment.newInstance();
                gotIt.show(getFragmentManager(), "dialog");
            }
        });
    }


}
