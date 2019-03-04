package com.example.contacts.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.contacts.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ShowContactInfoActivity extends AppCompatActivity {

    private static final String NAME = "contactName";
    private static final String EMAIL = "contactEmail";

    private String contactName;
    private String contactEmail;

    public static void addExtras(Intent intent, String nome, String email){
        intent.putExtra(NAME, nome);
        intent.putExtra(EMAIL, email);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact_info);
        buildToolbar();
        initializeVariables();
        initializeViews();
    }

    private void buildToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.show_contact_info);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initializeVariables(){
        contactName = getIntent().getStringExtra(NAME);
        contactEmail = getIntent().getStringExtra(EMAIL);
    }

    private void initializeViews(){
        TextView name = findViewById(R.id.tv_name);
        TextView email = findViewById(R.id.tv_email);
        name.setText(contactName);
        email.setText(contactEmail);
    }
}
