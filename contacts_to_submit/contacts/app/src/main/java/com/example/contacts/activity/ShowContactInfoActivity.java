package com.example.contacts.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.contacts.R;
import com.example.contacts.model.ContactDao;
import com.example.contacts.model.ContactModel;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ShowContactInfoActivity extends AppCompatActivity {

    private static final String POSITION = "position";

    private int position;
    private List<ContactModel> contactList;

    private Button remove;

    public static void addExtras(Intent intent, int position) {
        intent.putExtra(POSITION, position);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact_info);
        buildToolbar();
        initializeVariables();
        initializeViews();
        removeContact();
    }

    private void buildToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.show_contact_info);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initializeVariables(){
        position = getIntent().getIntExtra(POSITION, -1);
        contactList = ContactDao.getInstance().getContactList();
    }

    private void initializeViews(){
        TextView name = findViewById(R.id.tv_name);
        TextView email = findViewById(R.id.tv_email);
        TextView address = findViewById(R.id.tv_address);
        TextView businessPhone = findViewById(R.id.tv_business_phone);
        TextView homePhone = findViewById(R.id.tv_home_phone);

        name.setText(contactList.get(position).getNome());
        email.setText(contactList.get(position).getEmail());
        address.setText(contactList.get(position).getEndereco());
        businessPhone.setText(contactList.get(position).getTelefoneCom());
        homePhone.setText(contactList.get(position).getTelefoneRes());

        remove = findViewById(R.id.btn_remove);
    }

    private void removeContact() {
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactList.remove(position);
                finish();
            }
        });
    }

}
