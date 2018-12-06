package com.example.dmendez.projet_android_dylan_julian;

import android.content.Context;

import java.util.ArrayList;

public class collectionPersonnage {

    ArrayList<Personnage> ensPersonnage = new ArrayList<>();
    gestionBdd base_qcm;

    public void insertion_personnage(Context un_context) {
        base_qcm = new gestionBdd(un_context);

        ensPersonnage = base_qcm.getLesPersonnages();

        if (ensPersonnage.isEmpty()) {
            base_qcm.ajoutPersonnage(new Personnage(1 , "Asterix"));
            base_qcm.ajoutPersonnage(new Personnage(2, "Titeuf"));
            base_qcm.ajoutPersonnage(new Personnage(3, "Schtroumpf"));
            base_qcm.ajoutPersonnage(new Personnage(4, "Manu"));
            base_qcm.ajoutPersonnage(new Personnage(5, "Bille"));
            base_qcm.ajoutPersonnage(new Personnage(6, "Boule"));
            base_qcm.ajoutPersonnage(new Personnage(7, "Luckyluke"));

            //ensPersonnage = base_qcm.getLesPersonnages();

        }

    }

    //Retourne le nombre de personnage présent dans la collection.
    public int nb_perso(){ return ensPersonnage.size();}

    public String getNomP(int nomP){return ensPersonnage.get(nomP).getNomPersonnage();}



}


