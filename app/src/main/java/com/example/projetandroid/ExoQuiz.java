package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ExoQuiz  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_quiz);
    }

    public void QuizHistoire(View view) {
        Intent QCM = new Intent(ExoQuiz.this, QcmActivity.class);
        QCM.putExtra(QcmActivity.TOPIC, "hist");
        startActivity(QCM);
    }

    public void QuizGeo(View view) {
        Intent QCM = new Intent(ExoQuiz.this, QcmActivity.class);
        QCM.putExtra(QcmActivity.TOPIC, "geo");
        startActivity(QCM);
    }
}
