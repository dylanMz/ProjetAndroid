package com.example.dmendez.projet_android_dylan_julian;

import android.app.Activity;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AccueilActivity extends Activity implements View.OnClickListener {

    private ImageView imageJeu1;
    private ImageView imageJeu2;
    private EditText editTextPrenom;
    private String lePrenom;
    private ImageView imageRegles;

    private collectionPersonnage liste_personnage = new collectionPersonnage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        //Initilisation des controles android studio
        imageJeu1 = (ImageView) this.findViewById(R.id.imageView_Jeu1);
        imageJeu2 = (ImageView) this.findViewById(R.id.imageView_Jeu2);
        imageRegles = (ImageView) this.findViewById(R.id.imageView_regles);
        editTextPrenom = (EditText) this.findViewById(R.id.editText_prenom);

        liste_personnage.insertion_personnage(getApplicationContext());

        imageJeu1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent unIntent = new Intent(AccueilActivity.this, MainActivity.class);
                lePrenom = editTextPrenom.getText().toString();
                unIntent.putExtra("Joueur", lePrenom);

                //Si l'utilisateur n'insère pas son prénom, le jeu ne se lance pas et un message apparait pour lui indiquer
                if(lePrenom.isEmpty() || lePrenom.length() > 20){


                }

                //Le jeu se lance lorque l'utilisateur a inséré son prénom
                else {
                    startActivity(unIntent);
                }

            }
        });

        imageRegles.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent unIntent = new Intent(AccueilActivity.this, RegleActivity.class);
                startActivity(unIntent);

            }
        });


    }

    @Override
    public void onClick(View view) {

    }
}
