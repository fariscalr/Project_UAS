package com.fariscal_ramadhan;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;


public class Komentar extends AppCompatActivity {
    ImageView imageView;
    Button button, buttonSend;
    EditText editTextComment;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_komentar);

        imageView = findViewById(R.id.image_view);
        button = findViewById(R.id.button);
        buttonSend = findViewById(R.id.buttonSend);
        editTextComment = findViewById(R.id.editTextComment);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 101);
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = editTextComment.getText().toString();
                sendEmail(comment);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                imageView.setImageBitmap(imageBitmap);

                imageUri = saveImageToStorage(imageBitmap);
            }
        }
    }

    private Uri saveImageToStorage(Bitmap bitmap) {
        String imagePath = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Image", null);
        return Uri.parse(imagePath);
    }

    private void sendEmail(String comment) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("image/*");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"fariscalramadhan@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Komentar dari Aplikasi Tempat Wisata Indonesia");

        emailIntent.putExtra(Intent.EXTRA_TEXT, comment);

        if (imageUri != null) {
            emailIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        }

        startActivity(Intent.createChooser(emailIntent, "Kirim email..."));
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MenuUtama.class);
        startActivity(intent);
        finish();
    }
}

