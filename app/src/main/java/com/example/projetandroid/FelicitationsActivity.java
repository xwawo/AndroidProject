package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FelicitationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicitations);
    }

    public void choixTable(View view) {
        Intent intent = new Intent(this, TablesMultiplication.class);
        startActivity(intent);
    }

    public void choixExercice(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}