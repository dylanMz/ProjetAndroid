package com.example.dmendez.projet_android_dylan_julian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ThemeActivity extends AppCompatActivity {

    private ImageView imgTheme1;
    private ImageView imgTheme2;
    private ImageView imgTheme3;
    private ImageView imgTheme4;

    private String lePrenom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        //Initialisation des controles
        imgTheme1 = (ImageView) this.findViewById(R.id.imageView_theme_1);
        imgTheme2 = (ImageView) this.findViewById(R.id.imageView_theme_2);
        imgTheme3 = (ImageView) this.findViewById(R.id.imageView_theme_3);
        imgTheme4 = (ImageView) this.findViewById(R.id.imageView_theme_4);

        //Récupère le nom du joueur
        lePrenom = this.getIntent().getExtras().getString("Joueur");

        //Lance le jeu avec le thème Astérix
        imgTheme1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent unIntent = new Intent(ThemeActivity.this, MainActivity.class);
                unIntent.putExtra("Joueur", lePrenom);
                unIntent.putExtra("theme", 1);
                startActivity(unIntent);

            }
        });

        //Lance le jeu avec le thème Simpson
        imgTheme2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent unIntent = new Intent(ThemeActivity.this, MainActivity.class);
                unIntent.putExtra("Joueur", lePrenom);
                unIntent.putExtra("theme", 11);
                startActivity(unIntent);

            }
        });

        //Lance le jeu avec le thème Tintin
        imgTheme3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent unIntent = new Intent(ThemeActivity.this, MainActivity.class);
                unIntent.putExtra("Joueur", lePrenom);
                unIntent.putExtra("theme", 2);
                startActivity(unIntent);

            }
        });

        //Lance le jeu avec tous les thèmes
        imgTheme4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent unIntent = new Intent(ThemeActivity.this, MainActivity.class);
                unIntent.putExtra("Joueur", lePrenom);
                unIntent.putExtra("theme", 3);
                startActivity(unIntent);

            }
        });

    }
}
