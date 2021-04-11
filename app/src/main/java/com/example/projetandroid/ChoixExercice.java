package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ChoixExercice extends AppCompatActivity {

    private TextView texte;
    private MyApplication mapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_choix_exercice);
        texte = findViewById(R.id.textView);
        //récupération de l'instance du user
        mapp = MyApplication.getInstance();
        texte.setText("Salut " + mapp.getPrenom() + "! Choisi le sujet qui t'interesse");
    }

    public void exercicesMath(View view) {
        Intent MathExercicesActivity = new Intent(ChoixExercice.this, ExoMath.class);
        startActivity(MathExercicesActivity);
    }

    public void exercisesQuiz(View view) {
        Intent QuizExercicesActivity = new Intent(ChoixExercice.this, ExoQuiz.class);
        startActivity(QuizExercicesActivity);
    }
}