package com.example.dmendez.projet_android_dylan_julian;

public class Theme {
    int idtheme;
    String libelleTheme;


    public Theme(){

    }

    public Theme(int idtheme, String libelleTheme){
        this.idtheme = idtheme;
        this.libelleTheme = libelleTheme;
    }

    public int getIdtheme() {
        return idtheme;
    }

    public void setIdtheme(int idtheme) {
        this.idtheme = idtheme;
    }

    public String getLibelle() {
        return libelleTheme;
    }

    public void setLibelle(String libelle) {
        this.libelleTheme = libelle;
    }
}
