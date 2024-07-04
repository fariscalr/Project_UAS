package com.fariscal_ramadhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.TextView;
import android.widget.Toast;

import com.fariscal_ramadhan.Bali.Bali;
import com.fariscal_ramadhan.Bandung.Bandung;
import com.fariscal_ramadhan.Bengkulu.Bengkulu;
import com.fariscal_ramadhan.Bogor.Bogor;
import com.fariscal_ramadhan.Jakarta.Jakarta;
import com.fariscal_ramadhan.Lombok.Lombok;
import com.fariscal_ramadhan.MyJourney.Myjourney;

public class MenuUtama extends AppCompatActivity {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, Bali.class);
                finish();
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, Lombok.class);
                finish();
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, Bengkulu.class);
                finish();
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, Bandung.class);
                finish();
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, Bogor.class);
                finish();
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, Jakarta.class);
                finish();
                startActivity(intent);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, Komentar.class);
                finish();
                startActivity(intent);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, Myjourney.class);
                finish();
                startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtama.this, MainActivity.class);
                startActivity(intent);
                finish(); // Mengakhiri activity saat ini
                Toast.makeText(MenuUtama.this, "Berhasil Logout", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showInfoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Project Aplikasi Ujian Akhir Semester Mobile Programming");

        // Membuat TextView untuk menampilkan informasi
        TextView textView = new TextView(this);
        textView.setText("Tema: Rekomendasi Tempat Wisata Indonesia\nNama: Fariscal Ramadhan\nNIM: 211011400865\nKelas: 06TPLE008");
        textView.setPadding(50, 20, 50, 20); // Atur padding sesuai kebutuhan
        builder.setView(textView);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}