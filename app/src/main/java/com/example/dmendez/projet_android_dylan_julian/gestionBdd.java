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

    public static final String reqCreationTablePerso = "CREATE TABLE " + NOM_BDD + "(" + id +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            nom  + " TEXT, " + nomimage + " TEXT) ;";
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

        System.out.println("ok creation fini !!!!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String reqSuppP = "DROP TABLE IF EXISTS " + NOM_BDD;
        sqLiteDatabase.execSQL(reqSuppP);
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

}
