package com.example.dmendez.projet_android_dylan_julian;
import android.content.Context;

import java.util.ArrayList;
public class collectionThemes {

    ArrayList<Theme> ensTheme = new ArrayList<>();
    ArrayList<Personnage> ensPersonnagetheme = new ArrayList<>();
    gestionBdd lagestionbdd;


    public String getLibelleTheme(int numTheme){
        numTheme++;

        Theme findedTheme = new Theme();

        for(int i = 0; i< ensTheme.size(); i++){

            if(ensTheme.get(i).getIdtheme() == numTheme ){
                findedTheme = ensTheme.get(i);
            }

        }
        return findedTheme.getLibelle();
    }


    public void insertion_theme(Context un_context){
        lagestionbdd = new gestionBdd(un_context);

        ensTheme = lagestionbdd.getLesThemes();

        if(ensTheme.isEmpty()){
            lagestionbdd.ajoutTheme(new Theme(1, "Astérix"));
            lagestionbdd.ajoutTheme(new Theme(2, "Tintin"));
            lagestionbdd.ajoutTheme(new Theme(11, "Simpson"));
        }
    }
}
