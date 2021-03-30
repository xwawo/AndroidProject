package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Array;


public class ErreursActivity extends AppCompatActivity {

    public static final String ERR = "1";
    private TextView nbErr;
    private LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erreurs);
        String nb = String.valueOf(getIntent().getIntExtra(ERR, 1));
        layout = findViewById(R.id.err_layout);
        nbErr = findViewById(R.id.erreurs);
        nbErr.setText("Nombre d'erreurs : " + nb);
    }

    public void choixTable(View view) {
        Intent intent = new Intent(this, TablesMultiplication.class);
        startActivity(intent);
    }

    public void correction(View view) {
        finish();
    }
}
