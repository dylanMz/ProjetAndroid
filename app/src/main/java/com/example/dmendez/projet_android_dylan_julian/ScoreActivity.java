package com.example.dmendez.projet_android_dylan_julian;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class ScoreActivity extends AppCompatActivity {

    private Button btnAccueil;
    private Button btnRetour;
    private TextView testJson;

    private ListView listeFacile;
    private ListView listeMoyen;
    private ListView listeDifficile;
    private ListView listeExtreme;

    private gestionBdd db =new gestionBdd(this);
    //private ArrayList<Score> ensScore = new ArrayList<>();
    //private Score unScore;
    private String lePrenom;
    private int numtheme;
    private ImageView imgInfoScore;

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

    private ArrayList<String> IdScoreE = new ArrayList<String>();
    private ArrayList<String> NameE = new ArrayList<String>();
    private ArrayList<String> ScoreE = new ArrayList<String>();

    String uneUrl = String.format("http://149.91.81.169/bdd_recuperation_score.php");
    private String TAG = MainActivity.class.getSimpleName();
    private ArrayList<HashMap<String, String>> List_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //Initilisation des controles android studio
        btnAccueil = (Button) this.findViewById(R.id.button_accueil);
        btnRetour = (Button) this.findViewById(R.id.button_retour);
        imgInfoScore = (ImageView) this.findViewById(R.id.imageView_infoScore);
        listeFacile = (ListView) this.findViewById(R.id.listview_score_facile);
        listeMoyen = (ListView) this.findViewById(R.id.listview_score_moyen);
        listeDifficile = (ListView) this.findViewById(R.id.listview_score_difficile);
        listeExtreme = (ListView) this.findViewById(R.id.listview_score_extreme);

        bdd = new gestionBdd(this);

        //Récupère le nom du joueur
        lePrenom = this.getIntent().getExtras().getString("Joueur");
        numtheme = this.getIntent().getExtras().getInt("theme");

        List_score = new ArrayList<>();
        new GetScore().execute();

        //getLesScoresFacile();
        //getLesScoresMoyen();
        //getLesScoresDifficile();
        //getLesScoreExtreme();

        //Permet de retourner a l'accueil
        btnAccueil.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent Intent1 = new Intent(ScoreActivity.this, AccueilActivity.class);
                startActivity(Intent1);

            }
        });

        //Permet de retourner sur le jeu
        btnRetour.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent Intent1 = new Intent(ScoreActivity.this, MainActivity.class);
                Intent1.putExtra("Joueur", lePrenom);
                Intent1.putExtra("theme", numtheme);
                startActivity(Intent1);

            }
        });

        //Permet d'afficher comment sont calculer les scores
        imgInfoScore.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                AlertDialog.Builder builder = new AlertDialog.Builder(ScoreActivity.this );
                builder.setTitle("Scores");
                builder.setMessage("Les scores sont calculés en fonction du nombre de personnages trouvés, si vous avez gagné, le temps restant non utilisé vous rapportent aussi des points.");

                // ajoute un bouton
                builder.setPositiveButton("OK", null);

                // Créer et affiche la boite de dialogue
                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });


    }

    private class GetScore extends AsyncTask<Void, Void, Void> {

        protected Void doInBackground(Void... arg0)
        {
            HttpHandler sh = new HttpHandler();
            // déclenche une requête sur l'url
            String url = uneUrl;
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONArray contacts = new JSONArray(jsonStr);
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
                        String nom = c.getString("nom");
                        String score = c.getString("score");
                        String niveau = c.getString("niveau");
                        HashMap<String, String> unScore  = new HashMap<>();
                        unScore.put("nom", nom);
                        unScore.put("score", score);
                        unScore.put("niveau", niveau);
                        List_score.add(unScore);

                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "erreur de Parse Json: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext()," erreur de Parse Json:" + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }

            } else {
                Log.e(TAG, "Pb récup Json sur le serveur.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext()," Pb récup Json sur le serveur. Voir Logcat!", Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            //Recupère la taille de la liste
            int tailleListeFacile;
            tailleListeFacile = List_score.size() - 1;

            //Tant qu'il y a des données dans la liste ajoute les scores et noms des joueurs dans les bonnes listes
            while (tailleListeFacile >= 0 )
            {
                if(List_score.get(tailleListeFacile).get("niveau").equals("Facile") & NameF.size() < 9)
                {
                    NameF.add(List_score.get(tailleListeFacile).get("nom"));
                    ScoreF.add(List_score.get(tailleListeFacile).get("score"));
                }

                if(List_score.get(tailleListeFacile).get("niveau").equals("Moyen") & NameM.size() < 9)
                {
                    NameM.add(List_score.get(tailleListeFacile).get("nom"));
                    ScoreM.add(List_score.get(tailleListeFacile).get("score"));
                }

                if(List_score.get(tailleListeFacile).get("niveau").equals("Difficile") & NameD.size() < 9)
                {
                    NameD.add(List_score.get(tailleListeFacile).get("nom"));
                    ScoreD.add(List_score.get(tailleListeFacile).get("score"));
                }

                if(List_score.get(tailleListeFacile).get("niveau").equals("Extreme") & NameE.size() < 9)
                {
                    NameE.add(List_score.get(tailleListeFacile).get("nom"));
                    ScoreE.add(List_score.get(tailleListeFacile).get("score"));
                }

                tailleListeFacile=tailleListeFacile-1;
            }


            //Les adapters prennent en paramètres les listes de scores et noms qui leurs correspondents
            Adapter unAdapterFacile = new Adapter(ScoreActivity.this, NameF,ScoreF);
            Adapter unAdapterMoyen = new Adapter(ScoreActivity.this, NameM,ScoreM);
            Adapter unAdapterDifficile = new Adapter(ScoreActivity.this, NameD,ScoreD);
            Adapter unAdapterExtreme = new Adapter(ScoreActivity.this, NameE,ScoreE);

            //Affiche dans les listview le contenu.
            listeFacile.setAdapter(unAdapterFacile);
            listeMoyen.setAdapter(unAdapterMoyen);
            listeDifficile.setAdapter(unAdapterDifficile);
            listeExtreme.setAdapter(unAdapterExtreme);


        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(ScoreActivity.this, "progression en cours... ", Toast.LENGTH_LONG).show();


        }

    }

    //Retourne l'ensemble des scores réalisés en mode facile
    /*public void getLesScoresFacile(){
        String reqSelect = "SELECT scoreJoueur, scoreNom FROM " + NOM_BDD2+ " WHERE "+niveau + " LIKE 'Facile' ORDER BY " +score + " DESC LIMIT 9";

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
        String reqSelect = "SELECT scoreJoueur, scoreNom FROM " + NOM_BDD2+ " WHERE "+niveau + " LIKE 'Moyen' ORDER BY " +score + " DESC LIMIT 9";

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
        String reqSelect = "SELECT scoreJoueur, scoreNom FROM " + NOM_BDD2+ " WHERE "+niveau + " LIKE 'Difficile' ORDER BY " +score + " DESC LIMIT 9";

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

    public void getLesScoreExtreme(){
        String reqSelect = "SELECT scoreJoueur, scoreNom FROM " + NOM_BDD2+ " WHERE "+niveau + " LIKE 'Extreme' ORDER BY " +score + " DESC LIMIT 9";

        SQLiteDatabase db = bdd.getReadableDatabase();
        Cursor unCurseur = db.rawQuery(reqSelect, null);
        IdScoreE.clear();
        NameE.clear();
        ScoreE.clear();
        if(unCurseur.moveToFirst()){
            do{
                //IdScoreD.add(unCurseur.getString(unCurseur.getColumnIndex(id2)));
                NameE.add(unCurseur.getString(unCurseur.getColumnIndex(nomJoueur)));
                ScoreE.add(unCurseur.getString(unCurseur.getColumnIndex(score)));

            }while (unCurseur.moveToNext());
        }
        Adapter ad = new Adapter(ScoreActivity.this, NameE, ScoreE);
        listeExtreme.setAdapter(ad);
        unCurseur.close();
    }
*/
}

