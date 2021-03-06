package com.example.projetandroid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import db.DatabaseClient;
import db.User;

import androidx.appcompat.app.AppCompatActivity;


public class CreerCompte extends AppCompatActivity {

    private MyApplication mapp;

    // DATA
    private DatabaseClient mDb;

    // VIEW
    private EditText editTextNomView;
    private EditText editTextPrenomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //récuération de l'instance de MyActivity
        mapp = MyApplication.getInstance();

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_creation_compte);

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        editTextNomView = findViewById(R.id.editTextNom);
        editTextPrenomView = findViewById(R.id.editTextPrenom);
    }

    public void CreationCompteValider(View view) {

        // Récupérer les informations contenues dans les vues
        final String sNom = editTextNomView.getText().toString().trim();
        final String sPrenom = editTextPrenomView.getText().toString().trim();

        // Vérifier les informations fournies par l'utilisateur
        if (sNom.isEmpty()) {
            editTextNomView.setError("Nom required");
            editTextNomView.requestFocus();
            return;
        }

        if (sPrenom.isEmpty()) {
            editTextPrenomView.setError("Prenom required");
            editTextPrenomView.requestFocus();
            return;
        }

        /**
         * Création d'une classe asynchrone pour sauvegarder l'utilisateur
         */
        class SaveUser extends AsyncTask<Void, Void, User> {

            @Override
            protected User doInBackground(Void... voids) {

                // creating a task
                User user = new User();
                user.setNom(sNom);
                user.setPrenom(sPrenom);
                user.setHighScore(0);

                // adding to database
                mDb.getAppDatabase()
                        .userDao()
                        .insert(user);

                // récupération de l'id dans la session
                mapp.setId(mDb.getAppDatabase().userDao().getAll().size());
                mapp.setHighScore(0);

                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);

                // Quand un utilisateur est créée, on arrête l'activité CreerCompte (on l'enleve de la pile d'activités)
                setResult(RESULT_OK);

                // récupération du nom et prénom dans la séssion avant l'enregistrement dans la bd qui pourrait prendre du temps
                mapp.setNom(sNom);
                mapp.setPrenom(sPrenom);
                finish();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        SaveUser su = new SaveUser();
        su.execute();
    }
}