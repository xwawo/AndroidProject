package com.example.projetandroid;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetandroid.data.QCM;

import db.DatabaseClient;
import db.User;

public class QcmActivity extends AppCompatActivity {
    public static final String TOPIC = "";
    QCM quiz;
    LinearLayout layout;
    TextView question;
    TextView text_score;
    RadioGroup reponses;
    Button boutonValider;
    int indexQ;
    int indexR;
    int score;

    //instance
    private MyApplication mapp;

    // DATA
    private DatabaseClient mDb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //instance BD
        mDb = DatabaseClient.getInstance(getApplicationContext());
        //instance current user
        mapp=MyApplication.getInstance();


        setContentView(R.layout.activity_qcm);
        String topic = getIntent().getStringExtra(TOPIC);
        layout = findViewById(R.id.qcm_layout);
        question = findViewById(R.id.text_question);
        reponses = findViewById(R.id.reponses_group);
        boutonValider = findViewById(R.id.btn_valider);
        text_score = findViewById(R.id.text_score);
        quiz = new QCM(topic);
        score = 0;
        indexR = 1;
        indexQ = 0;
        if (topic.equals("hist")) {
            indexQ = 20;
            indexR=21;
        }
        creerContexe();

    }

    public void validerReponse(View view) {
        if(reponses.getCheckedRadioButtonId()!=-1){
            indexR += 2;
            indexQ += 2;
            if (QCM.getReponses()[(indexQ/2)-1].equals(((RadioButton)findViewById(reponses.getCheckedRadioButtonId())).getText().toString())){
                score++;
                Toast.makeText(getApplicationContext(), "Bonne Reponse!!", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Mauvaise Reponse :(", Toast.LENGTH_LONG).show();
            }
            if (indexQ <= 38) {
            creerContexe();}
            else {
                Intent intent = new Intent(QcmActivity.this, FelicitationsActivity.class);
                Bundle extras = new Bundle();
                extras.putString("LIB", "quiz");
                extras.putInt("LVL",score);
                // enregistrement du score
                if (score > mapp.getHighScore()) {
                    mapp.setHighScore(score);
                    class SaveScoreUser extends AsyncTask<Void, Void, User> {

                        @Override
                        protected User doInBackground(Void... voids) {

                            // creating a task
                            User user = new User();
                            user.setNom(mapp.getNom());
                            user.setPrenom(mapp.getPrenom());
                            user.setHighScore(score);
                            user.setId(mapp.getId());

                            // adding to database
                            mDb.getAppDatabase()
                                    .userDao()
                                    .update(user);
                            return user;
                        }

                        @Override
                        protected void onPostExecute(User user) {
                            super.onPostExecute(user);

                            // Quand un utilisateur est créée, on arrête l'activité CreerCompte (on l'enleve de la pile d'activités)
                            setResult(RESULT_OK);
                            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
                            intent.putExtras(extras);
                            startActivity(intent);
                        }
                    }

                    //////////////////////////
                    // IMPORTANT bien penser à executer la demande asynchrone
                    SaveScoreUser ssu = new SaveScoreUser();
                    ssu.execute();
                } else {
                    intent.putExtras(extras);
                    startActivity(intent);
                }
            }

        }
        else {
            Toast.makeText(getApplicationContext(), "Veuillez cocher une case", Toast.LENGTH_LONG).show();
        }
    }

    public void creerContexe() {
        text_score.setText("Score : "+ score + "/10");
        question.setText(QCM.getQuestions(indexQ,0));
        for (int i = 0; i<=reponses.getChildCount(); i++) {
            View obj = reponses.getChildAt(i);
            if (obj instanceof RadioButton) {
                ((RadioButton) obj).setText(QCM.getQuestions(indexR,i));
            }
        }
    }
}
