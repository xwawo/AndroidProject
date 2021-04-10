package com.example.projetandroid;

import android.content.Intent;
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

public class QcmActivity extends AppCompatActivity {
    public static final String TOPIC = "";
    private QCM quiz;
    private LinearLayout layout;
    private TextView question;
    private TextView text_score;
    private RadioGroup reponses;
    private Button boutonValider;
    private int indexQ;
    private int indexR;
    private int score;
    private int limit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        limit = 19;
        if (topic.equals("hist")) {
            indexQ = 20;
            indexR=21;
            limit = 38;
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
            if (indexQ <= limit) {
            creerContexe();}
            else {
                Intent intent = new Intent(QcmActivity.this, FelicitationsActivity.class);
                Bundle extras = new Bundle();
                extras.putString("LIB", "quiz");
                extras.putInt("LVL",score);
                intent.putExtras(extras);
                startActivity(intent);
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
