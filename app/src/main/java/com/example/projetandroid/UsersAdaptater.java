package com.example.projetandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import db.User;

public class UsersAdaptater extends ArrayAdapter<User> {

    public UsersAdaptater(Context mCtx, List<User> userList) {
        super(mCtx, R.layout.template_user, userList);
    }

    /**
     * Remplit une ligne de la userView avec les informations de la multiplication associée
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Récupération de la multiplication
        final User user = getItem(position);

        // Charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_user, parent, false);

        // Récupération des objets graphiques dans le template
        TextView textViewUser = (TextView) rowView.findViewById(R.id.user);

        //
        textViewUser.setText(user.getId()+ ") " +user.getNom()+ " "+ user.getPrenom()+ " | high score culture : "+user.getHighScore());

        //
        return rowView;
    }
}
