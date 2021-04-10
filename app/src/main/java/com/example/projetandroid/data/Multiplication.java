package com.example.projetandroid.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Multiplication {
    private int table = 1;
    private int operande1;
    private int operande2;
    private Multiplication[] tables;
    private int[] resultats;

    public Multiplication(int n) {
        this.table = n;
    } //constructeur avec la table de multiplication


    public void setResultats() { //creation des resultats à partir de la table
        resultats = new int[10];
        for (int i = 0; i<=9; i++) {
            resultats[i] = (i+1)*this.table;
        }
    }

    public void setTables() { //creation des operations
        tables = new Multiplication[10];
        for (int i = 0; i<=9; i++) {
            Multiplication m = new Multiplication(this.table);
            m.setOperande1(i+1);
            m.setOperande2(this.table);
            tables[i] = m;
        }
    }

    public int getOperande1() {
        return operande1;
    }

    public int getOperande2() {
        return operande2;
    }

    public void setOperande1(int operande1) {
        this.operande1 = operande1;
    }

    public void setOperande2(int operande2) {
        this.operande2 = operande2;
    }

    public Multiplication[] getTables() {
        return tables;
    }

    public int[] getResultats() {
        return resultats;
    }
}
