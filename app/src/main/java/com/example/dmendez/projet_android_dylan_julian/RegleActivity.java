package com.example.dmendez.projet_android_dylan_julian;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RegleActivity extends Activity implements View.OnClickListener{

    private Button btnRetour;
    private ImageView imageFlecheDroite;
    private ImageView imageFlecheGauche;
    private ImageView imageJeu;
    private TextView txtRegle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regle);

        btnRetour = (Button) this.findViewById(R.id.button_retour2);
        imageFlecheDroite = (ImageView) this.findViewById(R.id.imageView_flechedroite);
        imageFlecheGauche = (ImageView) this.findViewById(R.id.imageView_flechegauche);
        txtRegle = (TextView) this.findViewById(R.id.textView_regle);
        imageJeu = (ImageView) this.findViewById(R.id.imageView_jeuScreen);

        //Permet de retourner à l'accueil
        btnRetour.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent1 = new Intent(RegleActivity.this, AccueilActivity.class);
                startActivity(intent1);
            }
        });

        //Permet de passer à la règle suivante
        imageFlecheDroite.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                txtRegle.setText("2/ Trouver tous les personnages le plus rapidement possibles !");
                imageJeu.setImageResource(R.drawable.imgappli2);
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}
