package com.example.dmendez.projet_android_dylan_julian;

import android.content.Context;

import java.util.ArrayList;

public class collectionPersonnage {

    ArrayList<Personnage> ensPersonnage = new ArrayList<>();
    gestionBdd base_qcm;

    public void insertion_personnage(Context un_context) {
        base_qcm = new gestionBdd(un_context);

        //ensPersonnage = base_qcm.getLesQuestions();

        if (ensPersonnage.isEmpty()) {
            base_qcm.ajoutPersonnage(new Personnage(1, "Asterix", "@drawable/asterix"));
            base_qcm.ajoutPersonnage(new Personnage(2, "Lukyluke", "@drawable/luckyluke"));
            base_qcm.ajoutPersonnage(new Personnage(3, "titeuf", "@drawable/titeuf"));
        }
    }

    //public String getPersonnage(String nomPersonnage){return ensPersonnage.get(nomPersonnage).getNomPersonnage();}

}