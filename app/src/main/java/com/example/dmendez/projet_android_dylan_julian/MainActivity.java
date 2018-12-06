package com.example.dmendez.projet_android_dylan_julian;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends Activity {

    private Button btnNiveau1;
    private Button btnNiveau2;
    private Button btnNiveau3;
    private Button btnAbandonner;
    private TextView txtAccueilMsg;
    private TextView txtTest;
    private String lePrenom;
    private TextView txtTimer;
    private ImageView imgAtrouver;
    private TextView txtMessageFin;

    private int uneSeconde;
    private int nbRandom;

    private collectionPersonnage liste_personnage = new collectionPersonnage();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initilisation des controles
        txtAccueilMsg = (TextView) this.findViewById(R.id.textView_msgAccueil);
        btnNiveau1 = (Button) this.findViewById(R.id.button_niveau1);
        btnNiveau2 = (Button) this.findViewById(R.id.button_niveau2);
        btnNiveau3 = (Button) this.findViewById(R.id.button_niveau3);
        txtTimer = (TextView) this.findViewById(R.id.textView_timer);
        imgAtrouver = (ImageView) this.findViewById(R.id.imageView_persoChercher);
        txtTest = (TextView) this.findViewById(R.id.textView_test);
        btnAbandonner = (Button) this.findViewById(R.id.button_abandonner);
        txtMessageFin = (TextView) this.findViewById(R.id.textView_messageFin);


        //Affiche le prénom du joueur
        lePrenom = this.getIntent().getExtras().getString("Joueur");
        txtAccueilMsg.setText("Bonne chance " + lePrenom + ", choisi un niveau !");


        liste_personnage.insertion_personnage(getApplicationContext());
        imgAtrouver.setImageResource(R.drawable.pointinterogation);


        btnNiveau1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                uneSeconde = 180;
                launchNiveau(uneSeconde);
                initImage();
            }
        });

        btnNiveau2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                uneSeconde = 120;
                launchNiveau(uneSeconde);
                initImage();
            }
        });

        btnNiveau3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                uneSeconde = 3;
                launchNiveau(uneSeconde);
                initImage();
            }
        });

        btnAbandonner.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                btnNiveau1.setEnabled(true);
                btnNiveau2.setEnabled(true);
                btnNiveau3.setEnabled(true);
                imgAtrouver.setImageResource(R.drawable.pointinterogation);
                btnAbandonner.setVisibility(View.INVISIBLE);
                txtTimer.setText("");

                txtMessageFin.setText("Tu as abandonné... mais c'est pas grave ! tu peux recommencer ! Clique sur un des niveaux !");

            }
        });

    }

    private void initImage()
    {
        //Aléatoire
        //Random rand = new Random();
        int nbMax = liste_personnage.ensPersonnage.size();
        //int n = rand.nextInt(nbMax); // Gives n such that 0 <= n < 20
        //txtTest.setText(String.valueOf(n));



        //txtTest.setText(String.valueOf(liste_personnage));
        Random unNombreR = new Random();
        nbRandom = unNombreR.nextInt(nbMax);
        String test = liste_personnage.getNomP(nbRandom);
        txtTest.setText(String.valueOf(test));
        int identifier= getResources().getIdentifier(test, "drawable", getPackageName());

        imgAtrouver.setImageResource(identifier);
    }


    public void launchNiveau(int wSeconde)
    {
        //Le bouton abandonner apparait
        btnAbandonner.setVisibility(View.VISIBLE);

        //Reinitilise le message de fin
        //txtMessageFin.setText("");

        //Instancie un timer
        final CountDownTimer countDownTimer = new CountDownTimer(wSeconde * 1000, 1000) {


            public void onTick(long millisUntilFinished) {
                txtTimer.setText("Temps restant : " + millisUntilFinished / 1000);
            }

            //Lorsque le timer est à 0, affiche Fin et le bouton recommencer apparait
            public void onFinish() {
                txtTimer.setText("Fin");
                btnAbandonner.setVisibility(View.INVISIBLE);
                imgAtrouver.setImageResource(R.drawable.pointinterogation);

            }

        };

        btnNiveau1.setEnabled(false);
        btnNiveau2.setEnabled(false);
        btnNiveau3.setEnabled(false);


        countDownTimer.start();
    }

}
