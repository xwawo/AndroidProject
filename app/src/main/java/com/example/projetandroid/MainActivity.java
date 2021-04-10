package com.example.projetandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import db.DatabaseClient;
import db.User;

public class MainActivity extends AppCompatActivity {

    MyApplication mapp;

    private static final int COMPTE_REQUEST = 0;

    private DatabaseClient mDb;
    private UsersAdaptater adapter;

    private ListView listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //récuération de l'instance de MyActivity
        mapp=MyApplication.getInstance();

        // Récupération du DatabaseClient
        mDb = DatabaseClient.getInstance(getApplicationContext());

        // Récupérer les vues
        listUser = findViewById(R.id.listUser);

        // Lier l'adapter au listView
        adapter = new UsersAdaptater(this, new ArrayList<User>());
        listUser.setAdapter(adapter);

        // EXEMPLE : Ajouter un événement click à la listView
        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Récupération de la tâche cliquée à l'aide de l'adapter
                User user = adapter.getItem(position);

                mapp.setId(user.getId());
                mapp.setNom(user.getNom());
                mapp.setPrenom(user.getPrenom());
                mapp.setHighScore(user.getHighScore());

                // Message
                Toast.makeText(MainActivity.this, "Click : " + user.getId()+ " "+ user.getPrenom()+ " "+ user.getNom(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void CreationCompte(View view) {
        Intent CreationCompteActivity = new Intent(MainActivity.this, CreerCompte.class);

        startActivityForResult(CreationCompteActivity, COMPTE_REQUEST);
    }

    public void JoueurAnonyme(View view) {
        Intent JouerActivity = new Intent(MainActivity.this, ChoixExercice.class);

        startActivity(JouerActivity);
    }

    public void JoueurIdentifier(View view) {

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

    private void getUsers() {
        ///////////////////////
        // Classe asynchrone permettant de récupérer des taches et de mettre à jour le listView de l'activité
        class GetUsers extends AsyncTask<Void, Void, List<User>> {

            @Override
            protected List<User> doInBackground(Void... voids) {
                List<User> userList = mDb.getAppDatabase()
                        .userDao()
                        .getAll();
                return userList;
            }

            @Override
            protected void onPostExecute(List<User> users) {
                super.onPostExecute(users);

                // Mettre à jour l'adapter avec la liste de taches
                adapter.clear();
                adapter.addAll(users);

                // Now, notify the adapter of the change in source
                adapter.notifyDataSetChanged();
            }
        }

        //////////////////////////
        // IMPORTANT bien penser à executer la demande asynchrone
        // Création d'un objet de type GetTasks et execution de la demande asynchrone
        GetUsers gu = new GetUsers();
        gu.execute();
    }


    @Override
    protected void onStart() {
        super.onStart();

        // Mise à jour des taches
        getUsers();

    }
}