package com.module.cameraopen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Define the pic id
    private static final int pic_id = 123;

    // Define the button and imageview type variable
    Button camera_open_id;
    ImageView click_image_id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        camera_open_id = (Button)findViewById(R.id.camera_button);
        click_image_id = (ImageView)findViewById(R.id.click_image);


        camera_open_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            { Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, pic_id);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {

            Bitmap photo = (Bitmap) data.getExtras().get("data");
            click_image_id.setImageBitmap(photo);
        }
    }
}