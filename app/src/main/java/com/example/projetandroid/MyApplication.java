package com.example.projetandroid;

import android.app.Application;

public class MyApplication extends Application {

    //instance unique de MyApplication
    public static MyApplication instance = null;

    private String nom = null;
    private String prenom = null;
    private int id;
    private int highScore;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    //instance unique de MyApplication
    public static MyApplication getInstance() {
        if (instance == null) {
            instance = new MyApplication();
        }
        return instance;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getHighScore() {
        return highScore;
    }
}
