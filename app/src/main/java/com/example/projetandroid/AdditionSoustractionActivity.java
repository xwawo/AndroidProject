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
    private TextView textNiveau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations_basiques);
        op = getIntent().getStringExtra(OP);
        niveau = getIntent().getIntExtra(String.valueOf(NIV),0);
        layout = findViewById(R.id.AddLayout);
        textNiveau = findViewById(R.id.text_niveau);
        textNiveau.setText("Niveau : " + (niveau+1));
        operations = new AdditionSoustraction(op,niveau);
        operations.setOperations(); //creation des operations
        operations.setResultats();  //creation des resultats

        for(AdditionSoustraction calculs : operations.getOperations()) { // affichage des operations
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul, null);
            TextView calc = (TextView) linearTMP.findViewById(R.id.text_calcul);
            calc.setText(calculs.getOperande1()+ " " + op + " " + calculs.getOperande2() + " = ");
            layout.addView(linearTMP);
        }
    }

    public void correctionOp(View view) {
        int[] resultats = operations.getResultats();
        int erreurs = 0; //nb d'erreurs
        for (int i = 1; i < layout.getChildCount(); i++) {
            if (layout.getChildAt(i) instanceof LinearLayout) {
                LinearLayout child = (LinearLayout) layout.getChildAt(i);
                EditText reponse = (EditText) child.findViewById(R.id.template_resultat);
                int rep = -1;
                if (!reponse.getText().toString().isEmpty()) {
                    rep = Integer.parseInt(reponse.getText().toString());
                    if (rep != resultats[i-3]) {
                        erreurs++;
                    }
                }
                else {
                    erreurs++;
                }

            }
        }
        if (erreurs == 0) {
            Intent intent = new Intent(AdditionSoustractionActivity.this, FelicitationsActivity.class);
            Bundle extras = new Bundle();
            extras.putString("LIB", op);
            extras.putInt("LVL", niveau); //on envoie le niveau courant qui sera ensuite incrementé si l'utilisateur decide de continuer
            intent.putExtras(extras);
            startActivity(intent);
        }
        else { //si il y a des erreurs..
            Intent intent2 = new Intent(AdditionSoustractionActivity.this, ErreursActivity.class);
            intent2.putExtra(ErreursActivity.LIB, op); //on envoie l'operation courante
            intent2.putExtra(ErreursActivity.ERR, erreurs/2); //on envoie le nombre d'erreurs divisé par deux car chaque operation passe deux fois dans la boucle for
            startActivity(intent2);
        }
    }
}
