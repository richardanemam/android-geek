package com.example.customerrorhint.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.customerrorhint.R;
import com.example.customerrorhint.customcomponent.CustomErrorHint;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private RadioGroup posicao;
    private Button btnValida;
    private CustomErrorHint hintUm;
    private CustomErrorHint hintDois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        email = findViewById(R.id.edt_email);
        posicao = findViewById(R.id.rg_posicao);
        btnValida = findViewById(R.id.btn_valida);
        hintUm = findViewById(R.id.hint_error_1);
        hintDois = findViewById(R.id.hint_error_2);
        initValida();
    }

    private void checkedRadio() {
        if (posicao.getCheckedRadioButtonId() == -1) {
            hintDois.addViewError();
            hintDois.setError("Seleciona aqui animal");
        } else {
            hintDois.removeViewError();
            Toast.makeText(MainActivity.this, "É tão difícil assim, Richard?", Toast.LENGTH_SHORT).show();
        }
    }

    private void preencherEditText() {

        if (TextUtils.isEmpty(email.getText())) {
            hintUm.addViewError();
            hintUm.setError("Está tudo errado Richard, seu desajeitado!");
        } else {
            hintUm.removeViewError();
            Toast.makeText(MainActivity.this, "Está certo Richard, finalmente", Toast.LENGTH_SHORT).show();
        }
    }


    private void initValida() {
        btnValida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preencherEditText();
                checkedRadio();
            }
        });
    }
}
