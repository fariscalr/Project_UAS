package com.fariscal_ramadhan.Bali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fariscal_ramadhan.MenuUtama;
import com.fariscal_ramadhan.R;

public class Bali extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bali);

        listView = findViewById(R.id.list);
        String[] values = new String[]{"Tirta Gangga", "Tegalalang Rice Terrace", "Gunung Batur"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = null;
                if (position == 0) {
                    myIntent = new Intent(view.getContext(), Tirta.class);
                } else if (position == 1) {
                    myIntent = new Intent(view.getContext(), Tegalalang.class);
                } else if (position == 2) {
                    myIntent = new Intent(view.getContext(), Gunung.class);
                }

                if (myIntent != null) {
                    startActivity(myIntent);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MenuUtama.class);
        startActivity(intent);
        finish();
    }
}
