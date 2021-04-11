package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetandroid.data.Multiplication;

import java.util.zip.Inflater;

public class TableMultiplicationActivity extends AppCompatActivity {

    public static final String TABLE = "1";
    private TextView rows;
    private EditText resultat;
    private LinearLayout layout;
    private int nb;
    private Multiplication tableMultipication;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication);
        nb = Integer.parseInt(getIntent().getStringExtra(TABLE));
        layout = findViewById(R.id.rowsLayout);
        tableMultipication = new Multiplication(nb);
        tableMultipication.setTables();
        tableMultipication.setResultats();

        for (Multiplication multi : tableMultipication.getTables()) {
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul, null);
            TextView calc = (TextView) linearTMP.findViewById(R.id.text_calcul);
            calc.setText(multi.getOperande1() + " x " + multi.getOperande2() + " = ");
            layout.addView(linearTMP);
        }
    }

    public void correctionTable(View view) {
        int[] resultats = tableMultipication.getResultats();
        int erreurs = 0;
        for (int i = 1; i < layout.getChildCount(); i++) {
            if (layout.getChildAt(i) instanceof LinearLayout) {
                LinearLayout child = (LinearLayout) layout.getChildAt(i);
                EditText reponse = (EditText) child.findViewById(R.id.template_resultat);
                int rep = -1;
                if (!reponse.getText().toString().isEmpty()) {
                    rep = Integer.parseInt(reponse.getText().toString());
                } else {
                    erreurs++;
                }
                if (rep != resultats[i - 1]) {
                    erreurs++;
                }
            }
        }
        if (erreurs == 0) {
            Intent intent = new Intent(TableMultiplicationActivity.this, FelicitationsActivity.class);
            Bundle extras = new Bundle();
            extras.putString("LIB", "*");
            intent.putExtras(extras);
            startActivity(intent);

        } else {
            Intent intent2 = new Intent(TableMultiplicationActivity.this, ErreursActivity.class);
            intent2.putExtra(ErreursActivity.LIB, "*");
            intent2.putExtra(ErreursActivity.ERR, erreurs / 2);
            startActivity(intent2);
        }
    }
}