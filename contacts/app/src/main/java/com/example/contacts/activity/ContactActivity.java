package com.example.contacts.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.contacts.R;
import com.example.contacts.adapter.ContactAdapter;
import com.example.contacts.model.ContactDao;
import com.example.contacts.model.ContactModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
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

    @Override
    protected void onResume() {
        super.onResume();
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
        recyclerView.setAdapter(new ContactAdapter(this, getContactList(), this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_contact:
                Intent intent = new Intent(this, CreateContactActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<ContactModel> getContactList() {
        return ContactDao.getInstance().getContactList();
    }

    @Override
    public void onClick(View itemView, int position) {
        Intent intent = new Intent(this, ShowContactInfoActivity.class);
        ShowContactInfoActivity.addExtras(intent, position);
        startActivity(intent);
    }
}