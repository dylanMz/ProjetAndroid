package com.example.dmendez.projet_android_dylan_julian;

public class Personnage {
    int idPersonnage;
    String nomPersonnage;

    //Constructeur
    public Personnage (int wid, String wnomPersonnage)
    {
        idPersonnage=wid;
        nomPersonnage = wnomPersonnage;
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

    public void setIdPersonnage(int idPersonnage) {
        this.idPersonnage = idPersonnage;
    }

    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

}
