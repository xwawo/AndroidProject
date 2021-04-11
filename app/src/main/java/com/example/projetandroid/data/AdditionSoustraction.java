package com.example.projetandroid.data;

import java.util.Random;

public class AdditionSoustraction {
    private int operande1;
    private int operande2;
    private String op;      // addition ou soustraction
    private AdditionSoustraction[] operations;
    private int[] resultats;
    private int niveau;

    public AdditionSoustraction(String s, int lvl) { //constructeur avec type d'operation et niveau de difficultè
        this.op = s;
        this.niveau = lvl;
    }

    public void setOperande1(int operande1) {
        this.operande1 = operande1;
    }

    public void setOperande2(int operande2) {
        this.operande2 = operande2;
    }

    public void setOperations() { //creation des operations de maniere aleatoire
        operations = new AdditionSoustraction[5];
        if (op.equals("+")) {
            for (int i = 0; i <= 4; i++) {
                AdditionSoustraction obj = new AdditionSoustraction("+", niveau);
                obj.setOperande1(getRandomNumberInRange(1, (int) (10 * Math.pow(10, niveau)))); //le niveau permet de gerer la difficulté des calculs
                obj.setOperande2(getRandomNumberInRange(1, (int) (10 * Math.pow(10, niveau))));
                operations[i] = obj;
            }
        } else {
            for (int i = 0; i <= 4; i++) {
                AdditionSoustraction obj = new AdditionSoustraction("-", niveau);
                obj.setOperande1(getRandomNumberInRange(1, (int) (10 * Math.pow(10, niveau))));
                obj.setOperande2(getRandomNumberInRange(1, obj.getOperande1()));
                operations[i] = obj;
            }
        }

    }


    public void setResultats() { //creation d'un tableau avec les resultats des operations
        resultats = new int[5];
        if (op.equals("+")) {
            for (int i = 0; i < operations.length; i++) {
                resultats[i] = operations[i].getOperande1() + operations[i].getOperande2();
            }
        } else {
            for (int j = 0; j < operations.length; j++) {
                resultats[j] = operations[j].getOperande1() - operations[j].getOperande2();
            }
        }
    }

    public int getOperande1() {
        return operande1;
    }

    public int getOperande2() {
        return operande2;
    }

    public String getOp() {
        return op;
    }

    public AdditionSoustraction[] getOperations() {
        return operations;
    }

    public int[] getResultats() {
        return resultats;
    }

    private static int getRandomNumberInRange(int min, int max) { //fonction permettant de retourner un nombre aleatoire compris entre 2 bornes

        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
