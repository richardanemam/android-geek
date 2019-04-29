package com.example.architecturecompenents.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.architecturecompenents.R;

public class AddEditNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "TITLE";
    public static final String EXTRA_DESCRIPTION = "DESCRIPTION";
    public static final String EXTRA_PRIORITY = "PRIORITY";
    public static final String EXTRA_ID = "ID";


    private EditText edTitle;
    private EditText edDescription;
    private NumberPicker npPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        initializeViews();
    }

    private void initializeViews() {
        edTitle = findViewById(R.id.et_title);
        edDescription = findViewById(R.id.et_description);
        npPriority = findViewById(R.id.np_priority);
        npPriority.setMinValue(1);
        npPriority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        if(getIntent().hasExtra(EXTRA_ID)){
            setTitle("Edit Note");
            edTitle.setText(getIntent().getStringExtra(EXTRA_TITLE));
            edDescription.setText(getIntent().getStringExtra(EXTRA_DESCRIPTION));
            npPriority.setValue(getIntent().getIntExtra(EXTRA_PRIORITY, 1));
        } else {
            setTitle("Add Note");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_add_note, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        
    }

    private void saveNote() {
        String title = edTitle.getText().toString();
        String description = edDescription.getText().toString();
        int priority = npPriority.getValue();

        if(title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(this, "Please insert a title and a description", Toast.LENGTH_LONG).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);

        if(getIntent().getIntExtra(EXTRA_ID, -1) != -1){
            data.putExtra(EXTRA_ID, getIntent().getIntExtra(EXTRA_ID, -1));
        }

        setResult(RESULT_OK, data);
        finish();

    }
}
