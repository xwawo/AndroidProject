package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ChoixExercice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_choix_exercice);
    }

    public void exercicesMath(View view) {
        Intent MathExercicesActivity = new Intent(ChoixExercice.this, ExoMath.class);

        startActivity(MathExercicesActivity);
    }

    public void exercisesQuiz(View view) {
    }
}