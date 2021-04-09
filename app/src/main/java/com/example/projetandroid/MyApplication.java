package com.example.projetandroid;

import android.app.Application;

public class MyApplication extends Application {

    public static MyApplication instance=null;
    private String nom = null;
    private String prenom = null;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static MyApplication getInstance()
    {
        if(instance==null)
        {
            instance=new MyApplication();
        }
        return instance;
    }

    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
