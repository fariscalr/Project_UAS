package com.fariscal_ramadhan.MyJourney;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.fariscal_ramadhan.R;
import com.fariscal_ramadhan.database.DatabaseHelper;

public class UpdateJourney extends AppCompatActivity {

    EditText title, description;
    Button update, delete;
    String id, title1, description1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_journey);

        title = findViewById(R.id.title2);
        description = findViewById(R.id.description2);
        update = findViewById(R.id.update2);
        delete = findViewById(R.id.delete);

        getAndSetIntentData();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper mydb = new DatabaseHelper(UpdateJourney.this);
                title1 = title.getText().toString().trim();
                description1 = description.getText().toString().trim();
                mydb.updateData(id, title1, description1);

                title.setText("");
                description.setText("");
                Intent intent = new Intent(UpdateJourney.this, Myjourney.class);
                startActivity(intent);
                finish();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();

            }
        });

    }
    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
            getIntent().hasExtra("description")) {
            id = getIntent().getStringExtra("id");
            title1 = getIntent().getStringExtra("title");
            description1 = getIntent().getStringExtra("description");

            title.setText(title1);
            description.setText(description1);
        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + title1 );
        builder.setMessage("Apakah kamu yakin untuk menghapus " + title1 + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper mydb = new DatabaseHelper(UpdateJourney.this);
                mydb.deleteOneRow(id);

                Intent intent = new Intent(UpdateJourney.this, Myjourney.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, Myjourney.class);
        startActivity(intent);
        finish();
    }
}