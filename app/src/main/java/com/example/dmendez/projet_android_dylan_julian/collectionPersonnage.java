package com.example.dmendez.projet_android_dylan_julian;

import android.content.Context;

import java.util.ArrayList;

public class collectionPersonnage {

    ArrayList<Personnage> ensPersonnage = new ArrayList<>();
    gestionBdd base_qcm;

    public String getNomPerso(int numPerso){
        numPerso++;

        Personnage findedPersonnage = new Personnage();

        for(int i = 0; i< ensPersonnage.size(); i++){

            if(ensPersonnage.get(i).getIdPersonnage() == numPerso ){
                findedPersonnage = ensPersonnage.get(i);
            }

        }
        return findedPersonnage.getNomPersonnage();
    }

    public String getNomImage(int numImage){
        numImage++;

        Personnage findedPersonnage = new Personnage();

        for(int i = 0; i< ensPersonnage.size(); i++){

            if(ensPersonnage.get(i).getIdPersonnage() == numImage ){
                findedPersonnage = ensPersonnage.get(i);
            }

        }
        return findedPersonnage.getNomImage();
    }


    public void insertion_personnage(Context un_context) {
        base_qcm = new gestionBdd(un_context);

        ensPersonnage = base_qcm.getLesPersonnages();

        if (ensPersonnage.isEmpty()) {
            base_qcm.ajoutPersonnage(new Personnage(1, "Asterix", "asterix"));
            base_qcm.ajoutPersonnage(new Personnage(2, "Titeuf", "titeuf"));
            base_qcm.ajoutPersonnage(new Personnage(3, "Schtroumpf", "schtroumpf"));
            base_qcm.ajoutPersonnage(new Personnage(4, "Manu", "manu"));
            base_qcm.ajoutPersonnage(new Personnage(5, "Bill", "bill"));
            base_qcm.ajoutPersonnage(new Personnage(6, "Boule", "boule"));
            base_qcm.ajoutPersonnage(new Personnage(7, "Lucky-Luke", "luckyluke"));
            base_qcm.ajoutPersonnage(new Personnage(8, "Milou", "milou"));
            base_qcm.ajoutPersonnage(new Personnage(9, "Tintin", "tintin"));
            base_qcm.ajoutPersonnage(new Personnage(10, "Spirou", "spirou"));
            base_qcm.ajoutPersonnage(new Personnage(11, "Fantasio", "fantasio"));
            base_qcm.ajoutPersonnage(new Personnage(12, "Gaston", "gaston"));
            base_qcm.ajoutPersonnage(new Personnage(13, "Obélix", "obelix"));
            base_qcm.ajoutPersonnage(new Personnage(14, "Idéfix", "idefix"));
            base_qcm.ajoutPersonnage(new Personnage(15, "Abraracourcix", "abraracourcix"));
            //base_qcm.ajoutPersonnage(new Personnage(8, "gaston"));


            //ensPersonnage = base_qcm.getLesPersonnages();

        }

    }

    //Retourne le nombre de personnage présent dans la collection.
    public int nb_perso(){ return ensPersonnage.size();}

    public String getNomP(int nomP){return ensPersonnage.get(nomP).getNomPersonnage();}



}


