package com.example.contacts.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.contacts.R;
import com.example.contacts.model.ContactDao;
import com.example.contacts.model.ContactModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CreateContactActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText address;
    private EditText homePhone;
    private EditText businessPhone;
    private Button save;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        buildToolbar();
        initViews();
        saveContact();
    }

    private void buildToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.create_contact);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initViews() {
        name = findViewById(R.id.editText_name);
        email = findViewById(R.id.editText_email);
        address = findViewById(R.id.editText_address);
        businessPhone = findViewById(R.id.editText_business_phone);
        homePhone = findViewById(R.id.editText_home_phone);
        save = findViewById(R.id.button_save_contact);
    }

    private void saveContact() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContact();
                finish();
            }
        });
    }

    private void addContact() {
        ContactModel newContact = new ContactModel(name.getText().toString(),
                email.getText().toString(), address.getText().toString(),
                businessPhone.getText().toString(), homePhone.getText().toString());

        ContactDao contactDao = ContactDao.getInstance();
        contactDao.addContact(newContact);
    }
}
