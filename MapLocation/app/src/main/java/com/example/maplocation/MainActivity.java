package com.example.maplocation;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText maps;
    private Button btnShowMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startViews();
        startShowMap();
    }

    private void startViews() {
        maps = findViewById(R.id.editText_address);
        btnShowMap = findViewById(R.id.button_show_map);
    }

    private void startShowMap() {

        btnShowMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = maps.getText().toString().replace(' ', '+');
                Intent geoIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=" + address));
                geoIntent.setPackage("com.google.android.apps.maps");

                startActivity(geoIntent);

            }
        });
    }
}
