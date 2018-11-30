package com.example.dmendez.projet_android_dylan_julian;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;

public class gestionBdd extends SQLiteOpenHelper {

    // défini des constantes de classe
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "uneBdd";
    private static final String nom = "nom";
    private static final String chemin = "chemin";
    private static final String id = "id";


    // constructeur
    public gestionBdd(Context context){
        super(context, NOM_BDD, null, VERSION_BDD);
    }

    //surcharge de la méthode onCreate
    @Override
    public void onCreate(SQLiteDatabase objbdd){
        String maReq = "CREATE TABLE personnageBD ( id INTEGER PRIMARY KEY AUTOINCREMENT, nomPersonnage TEXT, cheminImage TEXT) ;";
        objbdd.execSQL(maReq);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long ajoutPersonnage(Personnage unPersonnage){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("idPersonnage",unPersonnage.getIdPersonnage());
        values.put("nomPersonnage",unPersonnage.getNomPersonnage());
        values.put("cheminPersonnage",unPersonnage.getCheminPersonnage());

        long insertion = db.insert("PersonnageBD", null, values);
        return insertion;
    }


    public ArrayList<Personnage> getLesPersonnages(){
        ArrayList<Personnage> ensPersonnage = new ArrayList<Personnage>();
        String reqSelect = " SELECT * FROM personnageBD ";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor unCurseur = db.rawQuery(reqSelect, null);
        if(unCurseur.moveToFirst()){
            do{
                Personnage un_personnage = new Personnage();
                un_personnage.setIdPersonnage(unCurseur.getInt(unCurseur.getColumnIndex(id)));
                un_personnage.setNomPersonnage(unCurseur.getString(unCurseur.getColumnIndex(nom)));
                un_personnage.setCheminPersonnage(unCurseur.getString(unCurseur.getColumnIndex(chemin)));

                ensPersonnage.add(un_personnage);
            }while (unCurseur.moveToNext());
            Collections.shuffle(ensPersonnage);
        }

        return ensPersonnage;
    }

}
