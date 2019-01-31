package com.example.dmendez.projet_android_dylan_julian;

import android.content.Context;

import java.util.ArrayList;

public class collectionPersonnage {

    ArrayList<Personnage> ensPersonnage = new ArrayList<>();
    ArrayList<Personnage> ensPersonnagetheme = new ArrayList<>();
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

    public void recup_theme(Context un_context,int numtheme){
        base_qcm = new gestionBdd(un_context);
        ensPersonnagetheme = base_qcm.getLesPersonnagesTheme(numtheme);
    }

    public String getTheme(int numimage){
        numimage++;
        Personnage findedPersonnage = new Personnage();

        for(int i = 0; i< ensPersonnagetheme.size(); i++){

            if(ensPersonnagetheme.get(i).getIdPersonnage() == numimage ){
                findedPersonnage = ensPersonnagetheme.get(i);
            }

        }
        return findedPersonnage.getNomImage();
    }


    public void insertion_personnage(Context un_context) {
        base_qcm = new gestionBdd(un_context);

        ensPersonnage = base_qcm.getLesPersonnages();

        if (ensPersonnage.isEmpty()) {
            base_qcm.ajoutPersonnage(new Personnage(1, "Asterix", "asterix", 1));
            base_qcm.ajoutPersonnage(new Personnage(2, "Titeuf", "titeuf", 3));
            base_qcm.ajoutPersonnage(new Personnage(3, "Schtroumpf", "schtroumpf", 4));
            base_qcm.ajoutPersonnage(new Personnage(4, "Manu", "manu", 3));
            base_qcm.ajoutPersonnage(new Personnage(5, "Bill", "bill", 5));
            base_qcm.ajoutPersonnage(new Personnage(6, "Boule", "boule", 5));
            base_qcm.ajoutPersonnage(new Personnage(7, "Lucky-Luke", "luckyluke", 6));
            base_qcm.ajoutPersonnage(new Personnage(8, "Milou", "milou", 2));
            base_qcm.ajoutPersonnage(new Personnage(9, "Tintin", "tintin", 2));
            base_qcm.ajoutPersonnage(new Personnage(10, "Spirou", "spirou", 7));
            base_qcm.ajoutPersonnage(new Personnage(11, "Fantasio", "fantasio", 7));
            base_qcm.ajoutPersonnage(new Personnage(12, "Gaston", "gaston", 8));
            base_qcm.ajoutPersonnage(new Personnage(13, "Obélix", "obelix", 1));
            base_qcm.ajoutPersonnage(new Personnage(14, "Idéfix", "idefix", 1));
            base_qcm.ajoutPersonnage(new Personnage(15, "Abraracourcix", "abraracourcix", 1));
            base_qcm.ajoutPersonnage(new Personnage(16, "Capitaine-Haddock", "capitainehaddock", 2));
            base_qcm.ajoutPersonnage(new Personnage(17, "Joe Dalton", "joedalton", 6));
            base_qcm.ajoutPersonnage(new Personnage(18, "Kid Paddle", "kidpaddle", 9));
            base_qcm.ajoutPersonnage(new Personnage(19, "Calimero", "calimero", 10));
            base_qcm.ajoutPersonnage(new Personnage(20, "Panoramix", "panoramix", 1));
            base_qcm.ajoutPersonnage(new Personnage(21, "Jules Cesar", "julescesar", 1));
            base_qcm.ajoutPersonnage(new Personnage(22, "Grand Schtroumpf", "grandschtroumpf", 4));
            base_qcm.ajoutPersonnage(new Personnage(23, "Gargamel", "gargamel", 4));
            base_qcm.ajoutPersonnage(new Personnage(24, "Homer Simpson", "homersimpson", 11));
            base_qcm.ajoutPersonnage(new Personnage(25, "Marge Simpson", "margesimpson", 11));
            base_qcm.ajoutPersonnage(new Personnage(26, "Bart Simpson", "bartsimpson", 11));
            base_qcm.ajoutPersonnage(new Personnage(27, "Flanders", "flanders", 11));
            base_qcm.ajoutPersonnage(new Personnage(28, "Marsupilami", "marsupilami", 12));
            base_qcm.ajoutPersonnage(new Personnage(29, "Grosminet", "grosminet", 13));
            //base_qcm.ajoutPersonnage(new Personnage(8, "gaston"));


            //ensPersonnage = base_qcm.getLesPersonnages();

        }

    }

    //Retourne le nombre de personnage présent dans la collection.
    public int nb_perso(){ return ensPersonnage.size();}

    public String getNomP(int nomP){return ensPersonnage.get(nomP).getNomPersonnage();}



}


