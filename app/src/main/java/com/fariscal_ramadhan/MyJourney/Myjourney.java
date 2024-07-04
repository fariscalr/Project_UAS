package com.fariscal_ramadhan.MyJourney;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fariscal_ramadhan.MenuUtama;
import com.fariscal_ramadhan.R;
import com.fariscal_ramadhan.database.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Myjourney extends AppCompatActivity {

    RecyclerView journey;
    FloatingActionButton add_button;

    DatabaseHelper mydb;
    ArrayList<String> id, title, description;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_myjourney);

        journey = findViewById(R.id.journey);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Myjourney.this, Addjourney.class);
                startActivity(intent);
            }
        });

        mydb = new DatabaseHelper(Myjourney.this);
        id = new ArrayList<>();
        title = new ArrayList<>();
        description = new ArrayList<>();

        StoreDataInArray();

        customAdapter = new CustomAdapter(Myjourney.this, id, title, description);
        journey.setAdapter(customAdapter);
        journey.setLayoutManager(new LinearLayoutManager(Myjourney.this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        id.clear();
        title.clear();
        description.clear();
        StoreDataInArray();
        customAdapter.notifyDataSetChanged();
    }

    void StoreDataInArray() {
        Cursor cursor = mydb.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                id.add(cursor.getString(0));
                title.add(cursor.getString(1));
                description.add(cursor.getString(2));
            }
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MenuUtama.class);
        startActivity(intent);
        finish();
    }
}
