package com.example.projetandroid.data;

import java.util.Random;

public class AdditionSoustraction {
    private int operande1;
    private int operande2;
    private String op;
    private AdditionSoustraction[] operations;
    private int[] resultats;

    public AdditionSoustraction(String s) {
        this.op = s;
    }

    public void setOperande1(int operande1) {
        this.operande1 = operande1;
    }

    public void setOperande2(int operande2) {
        this.operande2 = operande2;
    }

    public void setOperations() {
        operations = new AdditionSoustraction[5];
        if (op.equals("+")) {
            for (int i = 0; i<= 4; i++) {
                AdditionSoustraction obj = new AdditionSoustraction("+");
                obj.setOperande1(getRandomNumberInRange(1,10));
                obj.setOperande2(getRandomNumberInRange(1,10));
                operations[i] = obj;
            }
        }
        else {
            for (int i = 0; i<= 4; i++) {
                AdditionSoustraction obj = new AdditionSoustraction("-");
                obj.setOperande1(getRandomNumberInRange(1,10));
                obj.setOperande2(getRandomNumberInRange(1,10));
                while (operande2 > operande1) {
                    obj.setOperande2(getRandomNumberInRange(1,10));
                }
                operations[i] = obj;
            }
        }

    }


    public void setResultats() {
        if (getOp() == "+") {
            for (int i = 0; i <= operations.length; i++) {
                resultats[i] = operations[i].getOperande1() + operations[i].getOperande2();
            }
        }
        else {
            for (int i = 0; i <= operations.length; i++) {
                resultats[i] = operations[i].getOperande1() - operations[i].getOperande2();
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

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
