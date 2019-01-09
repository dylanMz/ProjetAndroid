package com.example.dmendez.projet_android_dylan_julian;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

public class gestionBdd extends SQLiteOpenHelper {

    // défini des constantes de classe
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "personnageBD";
    private static final String nom = "nomPersonnage";
    private static final String chemin = "chemin";
    private static final String id = "idPersonnage";
    private static  final String nomimage = "nomImage";

    private static final String NOM_BDD2 ="scoreJoueur";
    private static final String id2 = "idScore";
    private static final String score = "score";
    private static final String nomJoueur = "nomJoueur";
    private static final String niveau = "niveau";


    public static final String reqCreationTablePerso = "CREATE TABLE " + NOM_BDD + "(" + id +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            nom  + " TEXT, " + nomimage + " TEXT) ;";

    public static final String reqReqCreationTableScore = "CREATE TABLE " + NOM_BDD2 + "(" + id2 +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            score  + " INTEGER, " + nomJoueur + " TEXT, " + niveau +"TEXT) ;";

    // constructeur
    public gestionBdd(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }
    public gestionBdd(Context context){
        super(context,NOM_BDD, null, VERSION_BDD);
    }


    //surcharge de la méthode onCreate 
    @Override
    public void onCreate(SQLiteDatabase objbdd){
        Log.i("test base","insertion " + String.valueOf(reqCreationTablePerso));
        String reqSuppP = "DROP TABLE IF EXISTS " + NOM_BDD;
        objbdd.execSQL(reqSuppP);
        objbdd.execSQL(reqCreationTablePerso);

        Log.i("test base","insertion " + String.valueOf(reqReqCreationTableScore));
        String reqSuppP2 = "DROP TABLE IF EXISTS " + NOM_BDD2;
        objbdd.execSQL(reqSuppP2);
        objbdd.execSQL(reqReqCreationTableScore);


        System.out.println("ok creation fini !!!!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String reqSuppP = "DROP TABLE IF EXISTS " + NOM_BDD;
        sqLiteDatabase.execSQL(reqSuppP);
        onCreate(sqLiteDatabase);

        String reqSuppP2 = "DROP TABLE IF EXISTS " + NOM_BDD2;
        sqLiteDatabase.execSQL(reqSuppP2);
        onCreate(sqLiteDatabase);
    }

    public long ajoutPersonnage(Personnage unPersonnage){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("idPersonnage",unPersonnage.getIdPersonnage());
        values.put("nomPersonnage",unPersonnage.getNomPersonnage());
        values.put("nomImage",unPersonnage.getNomImage());

        long insertion = db.insert(NOM_BDD, null, values);
        return insertion;
    }

    public long ajoutScore(Score unScore){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("idScore",unScore.getIdScore());
        values.put("nomJoueur",unScore.getNomJoueur());
        values.put("score",unScore.getScoreJoueur());
        values.put("niveau",unScore.getScoreNiveau());


        long insertion = db.insert(NOM_BDD2, null, values);
        return insertion;

    }


    public ArrayList<Personnage> getLesPersonnages(){
        ArrayList<Personnage> ensPersonnage = new ArrayList<Personnage>();
        String reqSelect = " SELECT * FROM " + NOM_BDD;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor unCurseur = db.rawQuery(reqSelect, null);
        if(unCurseur.moveToFirst()){
            do{
                Personnage un_personnage = new Personnage();
                un_personnage.setIdPersonnage(unCurseur.getInt(unCurseur.getColumnIndex(id)));
                un_personnage.setNomPersonnage(unCurseur.getString(unCurseur.getColumnIndex(nom)));
                un_personnage.setNomImage(unCurseur.getString(unCurseur.getColumnIndex(nomimage)));

                ensPersonnage.add(un_personnage);
            }while (unCurseur.moveToNext());
            Collections.shuffle(ensPersonnage);
        }

        return ensPersonnage;
    }

    public ArrayList<Score> getLesScores(){
        ArrayList<Score> ensScore = new ArrayList<Score>();
        String reqSelect = " SELECT * FROM " + NOM_BDD2;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor unCurseur = db.rawQuery(reqSelect, null);
        if(unCurseur.moveToFirst()){
            do{
                Score un_score = new Score();
                un_score.setScoreId(unCurseur.getInt(unCurseur.getColumnIndex(id2)));
                un_score.setScoreJoueur(unCurseur.getInt(unCurseur.getColumnIndex(score)));
                un_score.setScoreNom(unCurseur.getString(unCurseur.getColumnIndex(nomJoueur)));
                un_score.setScoreNiveau(unCurseur.getString(unCurseur.getColumnIndex(niveau)));


                ensScore.add(un_score);
            }while (unCurseur.moveToNext());
            Collections.shuffle(ensScore);
        }

        return ensScore;
    }

}
