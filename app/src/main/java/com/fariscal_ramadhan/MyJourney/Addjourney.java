package com.fariscal_ramadhan.MyJourney;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.fariscal_ramadhan.R;
import com.fariscal_ramadhan.database.DatabaseHelper;

public class Addjourney extends AppCompatActivity {

    EditText title, description;
    Button simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addjourney);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        simpan = findViewById(R.id.simpan);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper DB = new DatabaseHelper(Addjourney.this);
                DB.addJourney(title.getText().toString().trim(),
                        description.getText().toString().trim());
                title.setText("");
                description.setText("");
                Intent intent = new Intent(Addjourney.this, Myjourney.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, Myjourney.class);
        startActivity(intent);
        finish();
    }
}
