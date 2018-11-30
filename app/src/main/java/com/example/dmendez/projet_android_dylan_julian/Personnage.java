package com.example.dmendez.projet_android_dylan_julian;

public class Personnage {
    int idPersonnage;
    String nomPersonnage;
    String cheminPersonnage;

    //Constructeur
    public Personnage (int wid, String wnomPersonnage, String wcheminPersonnage)
    {
        idPersonnage=wid;
        nomPersonnage = wnomPersonnage;
        cheminPersonnage = wcheminPersonnage;
    }

    public Personnage() {

    }

    //Accesseurs
    public int getIdPersonnage() {
        return idPersonnage;
    }

    public String getNomPersonnage() {
        return nomPersonnage;
    }

    public String getCheminPersonnage() {
        return cheminPersonnage;
    }

    public void setIdPersonnage(int idPersonnage) {
        this.idPersonnage = idPersonnage;
    }

    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    public void setCheminPersonnage(String cheminPersonnage) {
        this.cheminPersonnage = cheminPersonnage;
    }
}
