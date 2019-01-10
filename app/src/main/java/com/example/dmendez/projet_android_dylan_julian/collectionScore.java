package com.example.dmendez.projet_android_dylan_julian;

import android.content.Context;

import java.util.ArrayList;

public class collectionScore {
    ArrayList<Score> ensScore = new ArrayList<>();
    gestionBdd base_qcm;


    public void insertion_score(Context un_context, int wScore, String wNom, String wNiveau) {
        base_qcm = new gestionBdd(un_context);

        ensScore = base_qcm.getLesScores();

        base_qcm.ajoutScore(new Score(wScore, wNom,wNiveau));


    }


}
