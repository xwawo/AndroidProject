package com.example.projetandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetandroid.data.AdditionSoustraction;
import com.example.projetandroid.data.Multiplication;

public class AdditionSoustractionActivity extends AppCompatActivity {

    public static final String OP = "";
    private LinearLayout layout;
    private AdditionSoustraction operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations_basiques);
        String op = getIntent().getStringExtra(OP);
        layout = findViewById(R.id.AddLayout);
        operations = new AdditionSoustraction("op");
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

    }
}
