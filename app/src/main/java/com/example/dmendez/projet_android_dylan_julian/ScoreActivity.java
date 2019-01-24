package com.example.dmendez.projet_android_dylan_julian;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {
    private Button btnAccueil;
    private Button btnRetour;

    private ListView listeFacile;
    private ListView listeMoyen;
    private ListView listeDifficile;
    private Adapter unadapter;
    private gestionBdd db =new gestionBdd(this);
    private ArrayList<Score> ensScore = new ArrayList<>();
    private Score unScore;
    private String lePrenom;
    //private ImageView bordure1;
    //private ImageView bordure2;


    private static final String NOM_BDD2 ="scoreBD";
    private static final String id2 = "scoreId";
    private static final String score = "scoreJoueur";
    private static final String nomJoueur = "scoreNom";
    private static final String niveau = "scoreNiveau";

    private gestionBdd bdd;
        private ArrayList<String> IdScoreF = new ArrayList<String>();
        private ArrayList<String> NameF = new ArrayList<String>();
        private ArrayList<String> ScoreF = new ArrayList<String>();

        private ArrayList<String> IdScoreM = new ArrayList<String>();
        private ArrayList<String> NameM = new ArrayList<String>();
        private ArrayList<String> ScoreM = new ArrayList<String>();

        private ArrayList<String> IdScoreD = new ArrayList<String>();
        private ArrayList<String> NameD = new ArrayList<String>();
        private ArrayList<String> ScoreD = new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //Initilisation des controles android studio
        btnAccueil = (Button) this.findViewById(R.id.button_accueil);
        btnRetour = (Button) this.findViewById(R.id.button_retour);

        listeFacile = (ListView) this.findViewById(R.id.listview_score_facile);
        listeMoyen = (ListView) this.findViewById(R.id.listview_score_moyen);
        listeDifficile = (ListView) this.findViewById(R.id.listview_score_difficile);

        //bordure1 = (ImageView) this.findViewById(R.id.

        bdd = new gestionBdd(this);

        lePrenom = this.getIntent().getExtras().getString("Joueur");


        getLesScoresFacile();
        getLesScoresMoyen();
        getLesScoresDifficile();







        //unadapter = new Adapter(getApplicationContext(), unScore.getNomJoueur() , );



        btnAccueil.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent Intent1 = new Intent(ScoreActivity.this, AccueilActivity.class);
                startActivity(Intent1);

            }
        });

        btnRetour.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent Intent1 = new Intent(ScoreActivity.this, MainActivity.class);
                Intent1.putExtra("Joueur", lePrenom);
                startActivity(Intent1);

            }
        });






    }

    //Retourne l'ensemble des scores réalisés en mode facile
    public void getLesScoresFacile(){
        String reqSelect = "SELECT scoreJoueur, scoreNom FROM " + NOM_BDD2+ " WHERE "+niveau + " LIKE 'Facile' ORDER BY " +score + " DESC";

        SQLiteDatabase db = bdd.getReadableDatabase();
        Cursor unCurseur = db.rawQuery(reqSelect, null);
        IdScoreF.clear();
        NameF.clear();
        ScoreF.clear();
        if(unCurseur.moveToFirst()){
            do{
                //IdScoreF.add(unCurseur.getString(unCurseur.getColumnIndex(id2)));
                NameF.add(unCurseur.getString(unCurseur.getColumnIndex(nomJoueur)));
                ScoreF.add(unCurseur.getString(unCurseur.getColumnIndex(score)));

            }while (unCurseur.moveToNext());
        }
        Adapter ad = new Adapter(ScoreActivity.this, NameF, ScoreF);
        listeFacile.setAdapter(ad);
        unCurseur.close();
    }

    public void getLesScoresMoyen(){
        String reqSelect = "SELECT scoreJoueur, scoreNom FROM " + NOM_BDD2+ " WHERE "+niveau + " LIKE 'Moyen' ORDER BY " +score + " DESC";

        SQLiteDatabase db = bdd.getReadableDatabase();
        Cursor unCurseur = db.rawQuery(reqSelect, null);
        IdScoreM.clear();
        NameM.clear();
        ScoreM.clear();
        if(unCurseur.moveToFirst()){
            do{
                //IdScoreM.add(unCurseur.getString(unCurseur.getColumnIndex(id2)));
                NameM.add(unCurseur.getString(unCurseur.getColumnIndex(nomJoueur)));
                ScoreM.add(unCurseur.getString(unCurseur.getColumnIndex(score)));

            }while (unCurseur.moveToNext());
        }
        Adapter ad = new Adapter(ScoreActivity.this, NameM, ScoreM);
        listeMoyen.setAdapter(ad);
        unCurseur.close();

    }

    public void getLesScoresDifficile(){
        String reqSelect = "SELECT scoreJoueur, scoreNom FROM " + NOM_BDD2+ " WHERE "+niveau + " LIKE 'Difficile' ORDER BY " +score + " DESC";

        SQLiteDatabase db = bdd.getReadableDatabase();
        Cursor unCurseur = db.rawQuery(reqSelect, null);
        IdScoreD.clear();
        NameD.clear();
        ScoreD.clear();
        if(unCurseur.moveToFirst()){
            do{
                //IdScoreD.add(unCurseur.getString(unCurseur.getColumnIndex(id2)));
                NameD.add(unCurseur.getString(unCurseur.getColumnIndex(nomJoueur)));
                ScoreD.add(unCurseur.getString(unCurseur.getColumnIndex(score)));

            }while (unCurseur.moveToNext());
        }
        Adapter ad = new Adapter(ScoreActivity.this, NameD, ScoreD);
        listeDifficile.setAdapter(ad);
        unCurseur.close();
    }

}
