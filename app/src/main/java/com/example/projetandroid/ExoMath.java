package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ExoMath extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exo_math);
    }

    public void Additions(View view) {
        Intent intent = new Intent(ExoMath.this, AdditionSoustractionActivity.class);
        intent.putExtra(AdditionSoustractionActivity.OP,"+");
        startActivity(intent);
    }

    public void Multiplications(View view) {
        Intent TablesActivity = new Intent(ExoMath.this, TablesMultiplication.class);

        startActivity(TablesActivity);
    }

    public void Soustractions(View view) {
        Intent intent2 = new Intent(ExoMath.this, AdditionSoustractionActivity.class);
        intent2.putExtra(AdditionSoustractionActivity.OP,"-");
        startActivity(intent2);
    }
}
