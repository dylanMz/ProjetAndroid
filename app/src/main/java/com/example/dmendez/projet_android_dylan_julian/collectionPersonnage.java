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
    public void recup_theme(Context un_context,String libelleTheme){
        base_qcm = new gestionBdd(un_context);
        ensPersonnagetheme = base_qcm.getLesPersonnagesTheme(libelleTheme);
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


    public String getTheme(int numimage){
        Personnage findedPersonnage = new Personnage();

        for(int i = 0; i< ensPersonnagetheme.size(); i++){

            if(ensPersonnagetheme.get(i).getIdPersonnage() == numimage ){
                findedPersonnage = ensPersonnagetheme.get(i);
            }

        }
        return findedPersonnage.getNomImage();
    }

    public String getNomPersotheme(int numPerso){

        Personnage findedPersonnage = new Personnage();

        for(int i = 0; i< ensPersonnagetheme.size(); i++){

            if(ensPersonnagetheme.get(i).getIdPersonnage() == numPerso ){
                findedPersonnage = ensPersonnagetheme.get(i);
            }

        }
        return findedPersonnage.getNomPersonnage();
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
            base_qcm.ajoutPersonnage(new Personnage(30, "Epidemaïs", "epidemais", 1));
            base_qcm.ajoutPersonnage(new Personnage(31, "Praline", "praline", 1));
            base_qcm.ajoutPersonnage(new Personnage(32, "Mme Agecanonix", "mmeagecanonix", 1));
            base_qcm.ajoutPersonnage(new Personnage(33, "Marcus Sacapus", "marcussacapus", 1));
            base_qcm.ajoutPersonnage(new Personnage(34, "Goudurix", "goudurix", 1));
            base_qcm.ajoutPersonnage(new Personnage(35, "Falbala", "falbala", 1));
            base_qcm.ajoutPersonnage(new Personnage(36, "Assurancetourix", "assurancetourix", 1));
            base_qcm.ajoutPersonnage(new Personnage(37, "Agecanonix", "agecanonix", 1));
            base_qcm.ajoutPersonnage(new Personnage(38, "Bonemine", "bonemine", 1));
            base_qcm.ajoutPersonnage(new Personnage(39, "Cétautomatix", "cetautomatix", 1));
            base_qcm.ajoutPersonnage(new Personnage(40, "Cicatix", "cicatrix", 1));
            base_qcm.ajoutPersonnage(new Personnage(41, "Gélatine", "gelatine", 1));
            base_qcm.ajoutPersonnage(new Personnage(42, "Homéopatix", "homeopatix", 1));
            base_qcm.ajoutPersonnage(new Personnage(43, "Ordralfabétix", "ordralfabetix", 1));
            base_qcm.ajoutPersonnage(new Personnage(44, "Ignoramus", "ignoramus", 1));
            base_qcm.ajoutPersonnage(new Personnage(45, "Gracchus Garovirus", "gracchusgarovirus", 1));
            base_qcm.ajoutPersonnage(new Personnage(46, "Amonbofis", "amonbofis", 1));
            base_qcm.ajoutPersonnage(new Personnage(47, "Baba", "baba", 1));
            base_qcm.ajoutPersonnage(new Personnage(48, "Lisa", "lisa", 11));
            base_qcm.ajoutPersonnage(new Personnage(49, "Milhouse", "milhouse", 11));
            base_qcm.ajoutPersonnage(new Personnage(50, "Moe", "moe", 11));
            base_qcm.ajoutPersonnage(new Personnage(51, "Mr Burns", "mrburns", 11));
            base_qcm.ajoutPersonnage(new Personnage(52, "Nelson", "nelson", 11));
            base_qcm.ajoutPersonnage(new Personnage(53, "Waylon", "waylon", 11));
            base_qcm.ajoutPersonnage(new Personnage(54, "Edna", "edna", 11));
            base_qcm.ajoutPersonnage(new Personnage(55, "Barney", "barney", 11));
            base_qcm.ajoutPersonnage(new Personnage(56, "Seymour", "seymour", 11));
            base_qcm.ajoutPersonnage(new Personnage(57, "Abraham", "abraham", 11));
            base_qcm.ajoutPersonnage(new Personnage(58, "Gros Tony", "grostony", 11));
            base_qcm.ajoutPersonnage(new Personnage(59, "Patty", "patty", 11));
            base_qcm.ajoutPersonnage(new Personnage(60, "Ralph", "ralph", 11));
            base_qcm.ajoutPersonnage(new Personnage(61, "Clancy", "clancy", 11));
            base_qcm.ajoutPersonnage(new Personnage(62, "Hans_Taupeman", "hanstaupeman", 11));
            base_qcm.ajoutPersonnage(new Personnage(63, "Lenny", "lenny", 11));
            base_qcm.ajoutPersonnage(new Personnage(64, "Willie", "willie", 11));
            base_qcm.ajoutPersonnage(new Personnage(65, "Carl Carlson", "carlcarlson", 11));
            base_qcm.ajoutPersonnage(new Personnage(66, "Martin Prince", "martinprince", 11));
            base_qcm.ajoutPersonnage(new Personnage(67, "Lovejoy", "lovejoy", 11));
            base_qcm.ajoutPersonnage(new Personnage(68, "Luann", "luann", 11));
            base_qcm.ajoutPersonnage(new Personnage(69, "Kent Brockman", "kentbrockman", 11));
            //base_qcm.ajoutPersonnage(new Personnage(8, "gaston"));


            //ensPersonnage = base_qcm.getLesPersonnages();

        }

    }

    //Retourne le nombre de personnage présent dans la collection.
    public int nb_perso(){ return ensPersonnage.size();}

    public String getNomP(int nomP){return ensPersonnage.get(nomP).getNomPersonnage();}



}


