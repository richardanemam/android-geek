package com.example.contacts.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.example.contacts.R;
import com.example.contacts.adapter.ContactAdapter;
import com.example.contacts.model.ContactModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

public class ContactActivity extends AppCompatActivity implements ContactAdapter.onItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        buildToolbar();
        initializeRecyclerview();
    }

    private void buildToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initializeRecyclerview(){
        RecyclerView recyclerView = findViewById(R.id.rv_contact);
        recyclerView.setHasFixedSize(true);
        LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ContactAdapter(this, onCreateListOfContacts(), this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_contact: //TODO setup the click and intent
                Intent intent = new Intent(this, CreateContactActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<ContactModel> onCreateListOfContacts(){
        String[] nome = {"Richard Anemam", "Wesley Costa", "Fulano Silva", "Ciclano X",
                "Richard Anemam", "Wesley Costa", "Fulano Silva", "Ciclano X"};
        String[] email = {"anemamr@email.com","w.costa@email.com", "fulano.s@email.com",
                "ciclano@email.com", "anemamr@email.com","w.costa@email.com", "fulano.s@email.com",
                "ciclano@email.com"};

        List<ContactModel> contactsList = new ArrayList<>();
        for(int i = 0; i<nome.length; i++ ){
            ContactModel contact = new ContactModel(nome[i], email[i]);
            contactsList.add(contact);
        }
        return contactsList;
    }

    @Override
    public void onClick(View itemView, int position) {
        Intent intent = new Intent(this, ShowContactInfoActivity.class);
        List<ContactModel> contacts = onCreateListOfContacts();
        ShowContactInfoActivity.addExtras(intent, contacts.get(position).getNome(),
                contacts.get(position).getEmail());
        startActivity(intent);
    }
}