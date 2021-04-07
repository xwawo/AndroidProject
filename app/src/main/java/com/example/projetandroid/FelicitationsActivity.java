package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FelicitationsActivity extends AppCompatActivity {
    public static final String LIB = "";
    public static final String LVL = "";
    private Button bouton1;
    private Button bouton2;
    private String libelle;
    private int niveau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicitations);
        libelle = getIntent().getStringExtra(LIB);
        niveau = getIntent().getIntExtra(LVL, 1);
        bouton1 = findViewById(R.id.btn1);
        if (libelle.equals("+") || libelle.equals("-")) {
            if (niveau <= 3) {
                bouton1.setText("Passer au niveau suivant");
            }
            else {
                bouton1.setText("Choisir une autre operation");
            }
        }

    }

    public void Bouton1_click(View view) {
        if (libelle.equals("+") || libelle.equals("-")) {
            if (niveau <= 3) {
                Intent intent = new Intent(this, AdditionSoustractionActivity.class);
                intent.putExtra(String.valueOf(AdditionSoustractionActivity.NIV),niveau+1);
                intent.putExtra(AdditionSoustractionActivity.OP,libelle);
                startActivity(intent);

            }
            else {
                Intent intent = new Intent(this, ExoMath.class);
                startActivity(intent);
            }

        }
        else {
            Intent intent = new Intent(this, TablesMultiplication.class);
            startActivity(intent);
        }

    }

    public void choixExercice(View view) {
        Intent intent = new Intent(this, ChoixExercice.class);
        startActivity(intent);
    }
}