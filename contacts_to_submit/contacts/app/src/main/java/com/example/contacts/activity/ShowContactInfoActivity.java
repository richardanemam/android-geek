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

    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String ADDRESS = "address";
    private static final String BUSINESS_PHONE = "businessPhone";
    private static final String HOME_PHONE = "homePhone";

    private String contactName;
    private String contactEmail;
    private String contactAddress;
    private String contactBusinessPhone;
    private String contactHomePhone;

    public static void addExtras(Intent intent, String nome, String email, String address,
                                 String businessPhone, String homePhone){
        intent.putExtra(NAME, nome);
        intent.putExtra(EMAIL, email);
        intent.putExtra(ADDRESS, address);
        intent.putExtra(BUSINESS_PHONE, businessPhone);
        intent.putExtra(HOME_PHONE, homePhone);
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
        contactAddress = getIntent().getStringExtra(ADDRESS);
        contactBusinessPhone = getIntent().getStringExtra(BUSINESS_PHONE);
        contactHomePhone = getIntent().getStringExtra(HOME_PHONE);
    }

    private void initializeViews(){
        TextView name = findViewById(R.id.tv_name);
        TextView email = findViewById(R.id.tv_email);
        TextView address = findViewById(R.id.tv_address);
        TextView businessPhone = findViewById(R.id.tv_business_phone);
        TextView homePhone = findViewById(R.id.tv_home_phone);

        name.setText(contactName);
        email.setText(contactEmail);
        address.setText(contactAddress);
        businessPhone.setText(contactBusinessPhone);
        homePhone.setText(contactHomePhone);
    }
}
