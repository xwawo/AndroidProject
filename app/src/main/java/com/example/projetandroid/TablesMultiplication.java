package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

public class TablesMultiplication extends AppCompatActivity {

    NumberPicker liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_tables);
        liste = findViewById(R.id.liste);
        liste.setMinValue(1);
        liste.setMaxValue(10);
    }

    public void ExerciceTablesMultiplication(View view) {
        int nbTable = liste.getValue();
        Intent intent = new Intent(this, TableMultiplicationActivity.class);
        intent.putExtra(TableMultiplicationActivity.TABLE, String.valueOf(nbTable));
        startActivity(intent);
    }
}