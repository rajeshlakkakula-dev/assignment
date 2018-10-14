package com.rs.assignmenttest;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DetailsPage extends AppCompatActivity {
    TextView name;
    TextView designation;
    TextView location;
    TextView number;
    TextView date;
    TextView amount;
    ImageView image;

    private static final int MY_CAMERA_PERMISSION_CODE = 444;
    private static final int CAMERA_REQUEST = 8888;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);
        image = findViewById(R.id.image);
        name = findViewById(R.id.name);
        designation = findViewById(R.id.designation);
        location = findViewById(R.id.location);
        number = findViewById(R.id.number);
        date = findViewById(R.id.date);
        amount = findViewById(R.id.amount);
        image.setImageResource(R.drawable.camera_icon);
        String list_name = getIntent().getExtras().getString("name");
        String list_designation = getIntent().getExtras().getString("designation");
        String list_location = getIntent().getExtras().getString("location");
        String list_number = getIntent().getExtras().getString("number");
        String list_date = getIntent().getExtras().getString("date");
        String list_amount = getIntent().getExtras().getString("amount");
        name.setText(list_name);
        designation.setText(list_designation);
        location.setText(list_location);
        number.setText(list_number);
        date.setText(list_date);
        amount.setText(list_amount);


    }


    public void cameraButton(View view) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA},
                            MY_CAMERA_PERMISSION_CODE);
                }
            } else {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        }


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(photo);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new
                        Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }

        }


    }
}