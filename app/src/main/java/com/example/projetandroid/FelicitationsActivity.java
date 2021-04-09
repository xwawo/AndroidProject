package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FelicitationsActivity extends AppCompatActivity {
    private TextView texte;
    private Button bouton1;
    private Button bouton2;
    private String libelle;
    private int niveau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicitations);
        Bundle extras = getIntent().getExtras();
        libelle = extras.getString("LIB");
        niveau = extras.getInt("LVL",0);
        bouton1 = findViewById(R.id.btn1);
        texte = findViewById(R.id.feli_text);
        if (libelle.equals("+") || libelle.equals("-")) {
            if (niveau <= 3) {
                bouton1.setText("Passer au niveau suivant");
            }
            else {
                bouton1.setText("Choisir une autre operation");
            }
        }
        else if (libelle.equals("quiz")){
            texte.setText("Felicitations! Vous avez " + niveau + " bonnes reponses sur 10");
            bouton1.setText("Passer à un autre sujet");
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
        else if (libelle.equals("quiz")) {
            Intent intent = new Intent(this, ExoQuiz.class);
            startActivity(intent);
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