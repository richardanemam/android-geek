package com.example.errorhint;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private Button cliqueAqui;
    private TextInputLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarViews();
    }

    private void inicializarViews() {
        email = findViewById(R.id.email);
        cliqueAqui = findViewById(R.id.clique_aqui);
        container = findViewById(R.id.til_hint);
        inicializarClique();
    }

    private void inicializarClique() {
        cliqueAqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText())) {
                    container.setErrorEnabled(true);
                    container.setError("Está tudo errado Richard, seu desajeitado!");
                } else {
                    container.setErrorEnabled(false);
                    Toast.makeText(MainActivity.this, "Está certo Richard, finalmente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
