package com.example.alertlist;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnValidate;
    private EditText edtEmail;

    private String email;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        startViews();
    }

    private void startViews() {
        btnValidate = findViewById(R.id.button);
        edtEmail = findViewById(R.id.editText);

        emailListener();
        validateEmail();
    }

    private void emailListener() {
        edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Don't do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                email = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!isValidEmail(s.toString())) list.add("please, correct your email");
            }
        });
    }

    private boolean isValidEmail(String email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    private void showDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Title");
        dialog.setItem
    }

    private void validateEmail() {
        btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidEmail(email))
                    Toast.makeText(MainActivity.this, "It's a valid email", Toast.LENGTH_SHORT).show();
                else {
                    edtEmail.requestFocus();
                    ListDialog dialog = ListDialog.newInstance(list);
                    dialog.show(getSupportFragmentManager(), "dialog");
                    Toast.makeText(MainActivity.this, "It's not a valid email", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
