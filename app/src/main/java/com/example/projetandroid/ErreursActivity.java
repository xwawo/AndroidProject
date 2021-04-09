package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Array;


public class ErreursActivity extends AppCompatActivity {
    public static final String LIB = "";
    public static final String ERR = "1";
    private TextView nbErr;
    private LinearLayout layout;
    private String libelle;
    private Button bouton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreurs);
        String nb = String.valueOf(getIntent().getIntExtra(ERR, 1));
        layout = findViewById(R.id.err_layout);
        nbErr = findViewById(R.id.erreurs);
        libelle = getIntent().getStringExtra(LIB);
        bouton1 = findViewById(R.id.btn1);
        nbErr.setText("Nombre d'erreurs : " + nb);
        if (libelle.equals("+") || libelle.equals("-")) {
                bouton1.setText("Choisir une autre operation");
            }
        else {
                bouton1.setText("Choisir une autre table");
            }
        }

    public void choixExo(View view) {
        if (libelle.equals("+") || libelle.equals("-")) {
            Intent intent = new Intent(this, ExoMath.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, TablesMultiplication.class);
            startActivity(intent);
        }
    }

    public void correction(View view) {
        finish();
    }
}
