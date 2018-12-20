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


    public void insertion_personnage(Context un_context) {
        base_qcm = new gestionBdd(un_context);

        ensPersonnage = base_qcm.getLesPersonnages();

        if (ensPersonnage.isEmpty()) {
            base_qcm.ajoutPersonnage(new Personnage(1, "asterix"));
            base_qcm.ajoutPersonnage(new Personnage(2, "titeuf"));
            base_qcm.ajoutPersonnage(new Personnage(3, "schtroumpf"));
            base_qcm.ajoutPersonnage(new Personnage(4, "manu"));
            base_qcm.ajoutPersonnage(new Personnage(5, "bill"));
            base_qcm.ajoutPersonnage(new Personnage(6, "boule"));
            base_qcm.ajoutPersonnage(new Personnage(7, "luckyluke"));
            //base_qcm.ajoutPersonnage(new Personnage(8, "gaston"));


            //ensPersonnage = base_qcm.getLesPersonnages();

        }

    }

    //Retourne le nombre de personnage présent dans la collection.
    public int nb_perso(){ return ensPersonnage.size();}

    public String getNomP(int nomP){return ensPersonnage.get(nomP).getNomPersonnage();}



}


