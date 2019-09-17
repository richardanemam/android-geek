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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private Button cliqueAqui;
    private TextInputLayout container;
    private TextInputLayout teste;
    private RadioGroup radioGroup;
    private RadioButton primeiro;
    private RadioButton segundo;

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
        radioGroup = findViewById(R.id.radio);
        segundo = findViewById(R.id.segundo);
        teste = findViewById(R.id.teste);
        inicializarClique();
    }

    private void checkedRadio() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            teste.setErrorEnabled(true);
            teste.setError("Seleciona aqui animal");
        } else {
            teste.setErrorEnabled(false);
            Toast.makeText(MainActivity.this, "É tão difícil assim, Richard?", Toast.LENGTH_SHORT).show();
        }
    }

    private void preencherEditText() {
        if (TextUtils.isEmpty(email.getText())) {
            container.setErrorEnabled(true);
            container.setError("Está tudo errado Richard, seu desajeitado!");
        } else {
            container.setErrorEnabled(false);
            Toast.makeText(MainActivity.this, "Está certo Richard, finalmente", Toast.LENGTH_SHORT).show();
        }
    }

    private void inicializarClique() {
        cliqueAqui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preencherEditText();
                checkedRadio();
            }
        });
    }
}
