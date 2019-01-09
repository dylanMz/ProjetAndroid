package com.example.dmendez.projet_android_dylan_julian;

public class Score {

    int scoreId;
    int scoreJoueur;
    String scoreNom;
    String scoreNiveau;

    //Constructeur
    public Score (int wscoreId, int wscoreJoueur, String wscoreNom, String wscoreNiveau)
    {
        scoreId=wscoreId;
        scoreJoueur=wscoreJoueur;
        scoreNom=wscoreNom;
        scoreNiveau=wscoreNiveau;

    }

    public Score (int wscoreJoueur, String wscoreNom, String wscoreNiveau)
    {

        scoreJoueur=wscoreJoueur;
        scoreNom=wscoreNom;
        scoreNiveau=wscoreNiveau;

    }

    public Score() {

    }

    //Accesseurs
    public int getIdScore() {
        return scoreId;
    }

    public String getNomJoueur() {
        return scoreNom;
    }

    public int getScoreJoueur(){
        return  scoreJoueur;
    }

    public String getScoreNiveau() {return scoreNiveau;}

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public void setScoreNom(String scoreNom) {
        this.scoreNom = scoreNom;
    }

    public void setScoreJoueur(int scoreJoueur){
        this.scoreJoueur = scoreJoueur;
    }

    public void setScoreNiveau(String scoreNiveau){ this.scoreNiveau=scoreNiveau;}

}
