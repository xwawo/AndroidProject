package com.example.projetandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import db.DatabaseClient;
import db.User;

import androidx.appcompat.app.AppCompatActivity;

public class CreerCompte extends AppCompatActivity {

    // DATA
    private DatabaseClient mDb;

    // VIEW
    private EditText editTextNomView;
    private EditText editTextPrenomView;
    private Button button_saveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_creation_compte);

        // Récupérer les vues
        editTextNomView = findViewById(R.id.editTextNom);
        editTextPrenomView = findViewById(R.id.editTextPrenom);
        button_saveView = findViewById(R.id.button_save);
    }

    public void CreationCompteValider(View view) {


    }
}