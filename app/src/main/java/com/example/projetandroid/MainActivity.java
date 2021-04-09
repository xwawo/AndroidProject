package com.example.projetandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyApplication mapp;

    private static final int COMPTE_REQUEST = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //récuération de l'instance de MyActivity
        mapp=MyApplication.getInstance();
    }

    public void CreationCompte(View view) {
        Intent CreationCompteActivity = new Intent(MainActivity.this, CreerCompte.class);

        startActivityForResult(CreationCompteActivity, COMPTE_REQUEST);
    }

    public void JoueurAnonyme(View view) {
        Intent JouerActivity = new Intent(MainActivity.this, ChoixExercice.class);

        startActivity(JouerActivity);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COMPTE_REQUEST) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Retour OK", Toast.LENGTH_SHORT).show();
                if (mapp.getNom().isEmpty() && mapp.getPrenom().isEmpty()) {
                    Intent JouerActivity = new Intent(MainActivity.this, ChoixExercice.class);
                    startActivity(JouerActivity);
                } else {
                    Toast.makeText(this, mapp.getPrenom()+ " "+ mapp.getNom(), Toast.LENGTH_SHORT).show();
                }

            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Retour avec erreur", Toast.LENGTH_SHORT).show();
            }
        }
    }
}