package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CreationCompte(View view) {
        Intent CreationCompteActivity = new Intent(MainActivity.this, CreerCompte.class);

        startActivity(CreationCompteActivity);
    }

    public void JoueurAnonyme(View view) {
        Intent JouerActivity = new Intent(MainActivity.this, ChoixExercice.class);

        startActivity(JouerActivity);
    }
}