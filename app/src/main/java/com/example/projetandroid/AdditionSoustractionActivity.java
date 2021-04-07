package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetandroid.data.AdditionSoustraction;
import com.example.projetandroid.data.Multiplication;

public class AdditionSoustractionActivity extends AppCompatActivity {

    public static final String OP = "";
    public static final int NIV = 0;
    private LinearLayout layout;
    private AdditionSoustraction operations;
    private int niveau;
    private String op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations_basiques);
        op = getIntent().getStringExtra(OP);
        niveau = getIntent().getIntExtra(String.valueOf(NIV),0);
        layout = findViewById(R.id.AddLayout);
        operations = new AdditionSoustraction(op,niveau);
        operations.setOperations();
        operations.setResultats();

        for(AdditionSoustraction calculs : operations.getOperations()) {
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul, null);
            TextView calc = (TextView) linearTMP.findViewById(R.id.text_calcul);
            calc.setText(calculs.getOperande1()+ " " + op + " " + calculs.getOperande2() + " = ");
            layout.addView(linearTMP);
        }
    }

    public void correctionOp(View view) {
        int[] resultats = operations.getResultats();
        int erreurs = 0;
        for (int i = 2; i < layout.getChildCount(); i++) {
            if (layout.getChildAt(i) instanceof LinearLayout) {
                LinearLayout child = (LinearLayout) layout.getChildAt(i);
                EditText reponse = (EditText) child.findViewById(R.id.template_resultat);
                int rep = -1;
                if (!reponse.getText().toString().isEmpty()) {
                    rep = Integer.parseInt(reponse.getText().toString());
                } else {
                    erreurs++;
                }
                if (rep != resultats[i-2]) {
                    erreurs++;
                }
            }
        }
        if (erreurs == 0) {
            Intent intent = new Intent(AdditionSoustractionActivity.this, FelicitationsActivity.class);
            intent.putExtra(FelicitationsActivity.LVL,niveau );
            intent.putExtra(FelicitationsActivity.LIB, op);
            startActivity(intent);
        }
        else {
            Intent intent2 = new Intent(AdditionSoustractionActivity.this, ErreursActivity.class);
            intent2.putExtra(ErreursActivity.ERR, erreurs/2);
            startActivity(intent2);
        }
    }
}
