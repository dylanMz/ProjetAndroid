package com.example.dmendez.projet_android_dylan_julian;

public class Personnage {
    int idPersonnage;
    String nomPersonnage;
    String nomImage;
    int idTheme;

    //Constructeur
    public Personnage (int wid, String wnomPersonnage, String wnomImage)
    {
        idPersonnage=wid;
        nomPersonnage = wnomPersonnage;
        nomImage = wnomImage;
    }

    public Personnage (int wid, String wnomPersonnage, String wnomImage, int idTheme)
    {
        idPersonnage=wid;
        nomPersonnage = wnomPersonnage;
        nomImage = wnomImage;
        this.idTheme = idTheme;
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

    public String getNomImage(){
        return  nomImage;
    }

    public void setIdPersonnage(int idPersonnage) {
        this.idPersonnage = idPersonnage;
    }

    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    public void setNomImage(String nomImage){
        this.nomImage = nomImage;
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }
}
