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
    private static final String nomTableTheme = "THEME";
    private static final String NOM_BDD = "personnageBD";
    private static final String nom = "nomPersonnage";
    private static final String chemin = "chemin";
    private static final String id = "idPersonnage";
    private static  final String nomimage = "nomImage";

    private static final String NOM_BDD2 ="scoreBD";
    private static final String id2 = "scoreId";
    private static final String idtheme = "idtheme";
    private static final String score = "scoreJoueur";
    private static final String nomJoueur = "scoreNom";
    private static final String niveau = "scoreNiveau";
    private static final String libelletheme = "libelleTheme";

    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> Name = new ArrayList<String>();
    private ArrayList<String> Score = new ArrayList<String>();
    private ArrayList<String> Niveau = new ArrayList<String>();

    private ArrayList<String> IdScoreF = new ArrayList<String>();
    private ArrayList<String> NameF = new ArrayList<String>();
    private ArrayList<String> ScoreF = new ArrayList<String>();

    private String Facile = "Facile";
    private String Moyen = "Moyen";
    private String Difficile = "Difficile";
    private ScoreActivity scoreActivity;

    public static final String reqCreationTablePerso = "CREATE TABLE " + NOM_BDD + "(" + id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            nom  + " TEXT, " + nomimage + " TEXT, " + idtheme + " INTEGER) ;";

    public static final String reqReqCreationTableScore = "CREATE TABLE " + NOM_BDD2 + "(" + id2 +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            score  + " INTEGER, " + nomJoueur + " TEXT, " + niveau + " TEXT) ;";

    public static final String reqCreationTableTheme = "CREATE TABLE " + nomTableTheme + "(" + idtheme + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            libelletheme + " TEXT) ;";

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

    //Permet d'ajouter un objet personnage
    public long ajoutPersonnage(Personnage unPersonnage){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("idPersonnage",unPersonnage.getIdPersonnage());
        values.put("nomPersonnage",unPersonnage.getNomPersonnage());
        values.put("nomImage",unPersonnage.getNomImage());
        values.put("idtheme", unPersonnage.getIdTheme());

        long insertion = db.insert(NOM_BDD, null, values);
        return insertion;
    }

    /* UTILE POUR GERER LES SCORES EN LOCAL
    //Permet d'ajouter un score
    public long ajoutScore(Score unScore){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("scoreJoueur",unScore.getScoreJoueur());
        values.put("scoreNom",unScore.getNomJoueur());
        values.put("scoreNiveau",unScore.getScoreNiveau());


        long insertion = db.insert(NOM_BDD2, null, values);
        return insertion;

    }
*/
    //Retourne l'ensemble des personnages
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
                un_personnage.setIdTheme(unCurseur.getInt(unCurseur.getColumnIndex(idtheme)));

                ensPersonnage.add(un_personnage);
            }while (unCurseur.moveToNext());
            Collections.shuffle(ensPersonnage);
        }

        return ensPersonnage;
    }


    public ArrayList<Personnage> getLesPersonnagesTheme(int num_theme){
        ArrayList<Personnage> ensPersonnage = new ArrayList<Personnage>();
        String reqSelect = " SELECT * FROM " + NOM_BDD + " Where " + idtheme + " = " + num_theme;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor unCurseur = db.rawQuery(reqSelect, null);
        if(unCurseur.moveToFirst()){
            do{
                Personnage un_personnage = new Personnage();
                un_personnage.setIdPersonnage(unCurseur.getInt(unCurseur.getColumnIndex(id)));
                un_personnage.setNomPersonnage(unCurseur.getString(unCurseur.getColumnIndex(nom)));
                un_personnage.setNomImage(unCurseur.getString(unCurseur.getColumnIndex(nomimage)));
                un_personnage.setIdTheme(unCurseur.getInt(unCurseur.getColumnIndex(idtheme)));

                ensPersonnage.add(un_personnage);
            }while (unCurseur.moveToNext());
            Collections.shuffle(ensPersonnage);
        }

        return ensPersonnage;
    }

/* //UTILE POUR GERER LES SCORES EN LOCAL
    //Retourne l'ensemble des scores
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
    }*/
}
