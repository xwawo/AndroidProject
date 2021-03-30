package com.example.projetandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TableMultiplicationActivity extends AppCompatActivity {

    public static final String TABLE = "1" ;
    TextView rows;
    EditText resultat;
    LinearLayout layout;
    int nb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_multiplication);
        nb = Integer.parseInt(getIntent().getStringExtra(TABLE));
        layout = findViewById(R.id.rowsLayout);

        for (int i = 1; i<=10; i++) {
            LinearLayout layout_number = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul, null);
            rows = layout_number.findViewById(R.id.template_calcul);
            rows.setText(i +" x "+ nb + " = ");
            resultat = layout_number.findViewById(R.id.template_resultat);
            resultat.setHint("?");
            layout.addView(layout_number);
        }
    }

    public void correctionTable(View view) {
        int justes = 0;
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof LinearLayout && ((LinearLayout) child).getChildAt(i) instanceof EditText) {
                EditText reponse = (EditText) ((LinearLayout) child).getChildAt(i);
                int rep = -1;
                if (!reponse.getText().toString().isEmpty()) {
                    rep = Integer.parseInt(reponse.getText().toString());
                }
                if (rep != ((i+1)*nb)) {

                }
            }
        }

    }
}