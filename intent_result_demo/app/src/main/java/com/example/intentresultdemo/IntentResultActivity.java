package com.example.intentresultdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class IntentResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_result);
        setButtonHandler();
    }

    private void setButtonHandler() {
        Button pickButton = (Button) findViewById(R.id.pick_button);

        pickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleClick();
            }
        });
    }

    private void handleClick() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*"); //allows any image file type. Change * to specific extension to limit it
//**These following line is the important one!
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 0);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 0 && resultCode == RESULT_OK) {
//            Uri photoURI = data.getData();
//            ImageView imageView = (ImageView) findViewById(R.id.photo_container);
//            ImageView imageView2 = (ImageView) findViewById(R.id.photo_container2);
//
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView.setImageURI(photoURI);
//
//            imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageView2.setImageURI(photoURI);
//        }
//    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0) {
            if(resultCode == RESULT_OK) {
                if(data.getData() != null) {
                    int count = data.getClipData().getItemCount(); //evaluate the count before the for loop --- otherwise, the count is evaluated every loop.
                    for(int i = 0; i < count; i++) {
                        Uri imageUri = data.getClipData().getItemAt(i).getUri();
                        ImageView imageView = (ImageView) findViewById(R.id.photo_container);
                        ImageView imageView2 = (ImageView) findViewById(R.id.photo_container2);

                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imageView.setImageURI(imageUri);

                        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        imageView2.setImageURI(imageUri);
                    }
                    //do something with the image (save it to some directory or whatever you need to do with it here)
                }
            } else if(data.getData() != null) {
                String imagePath = data.getData().getPath();
                //do something with the image (save it to some directory or whatever you need to do with it here)
            }


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}
