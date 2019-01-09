package com.example.dmendez.projet_android_dylan_julian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class ScoreActivity extends AppCompatActivity {
    private Button btnAccueil;
    private Button btnRetour;

    private ListView listeFacile;
    private ListView listeMoyen;
    private ListView listeDifficile;

    

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
                startActivity(Intent1);

            }
        });






    }

}
