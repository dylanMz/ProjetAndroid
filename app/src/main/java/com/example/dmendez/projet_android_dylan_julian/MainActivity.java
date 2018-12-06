package com.example.dmendez.projet_android_dylan_julian;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import java.util.*;

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
    private ImageView imgChrono;
    private ImageView imageperso;
    private  ImageView imageperso1;
    private ImageView imageperso2;
    private ImageView imageperso3;
    private ImageView imageperso4;
    private ImageView imageperso5;
    private ImageView imageperso6;
    private String NomPerso;
    private int identifier;

    private int uneSeconde;
    private int nbRandom;
    private CountDownTimer countDownTimer;

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
        imgChrono = (ImageView) this.findViewById(R.id.imageView_chrono);
        imageperso = (ImageView) this.findViewById(R.id.imageView_perso);
        imageperso1 = (ImageView) this.findViewById(R.id.imageView_perso1);
        imageperso2 = (ImageView) this.findViewById(R.id.imageView_perso2);
        imageperso3 = (ImageView) this.findViewById(R.id.imageView_perso3);
        imageperso4 = (ImageView) this.findViewById(R.id.imageView_perso4);
        imageperso5 = (ImageView) this.findViewById(R.id.imageView_perso5);
        imageperso5 = (ImageView) this.findViewById(R.id.imageView_perso6);


        //Affiche le prénom du joueur
        lePrenom = this.getIntent().getExtras().getString("Joueur");
        txtAccueilMsg.setText("Bonne chance " + lePrenom + ", choisi un niveau !");



        liste_personnage.insertion_personnage(getApplicationContext());
        imgAtrouver.setImageResource(R.drawable.pointinterogation);


        btnNiveau1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                uneSeconde = 120;
                launchNiveau(uneSeconde);
                initImage();
            }
        });

        btnNiveau2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                uneSeconde = 60;
                launchNiveau(uneSeconde);
                initImage();
            }
        });

        btnNiveau3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                uneSeconde = 30;
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

                txtMessageFin.setVisibility(View.VISIBLE);
                txtMessageFin.setText("Tu as abandonné... mais c'est pas grave ! tu peux recommencer ! Clique sur un des niveaux !");


                imgChrono.setVisibility(View.INVISIBLE);
                txtTest.setText("");

                countDownTimer.cancel();

            }
        });

    }

    //Méthode affichant les images aléatoirement
    private void initImage()
    {

        int nbMax = liste_personnage.ensPersonnage.size();
        //int n = rand.nextInt(nbMax); // Gives n such that 0 <= n < 20
        //txtTest.setText(String.valueOf(n));


        Random unNombreR = new Random();
        nbRandom = unNombreR.nextInt(nbMax);
        String test = liste_personnage.getNomP(2);
        txtTest.setText(String.valueOf(test));
        int identifier= getResources().getIdentifier(test, "drawable", getPackageName());

        imgAtrouver.setImageResource(identifier);

        TreeSet unNombre = new TreeSet();
        Random NumRend = new Random();
        for(int i = 0; i<7; i++){
            int RandNum = NumRend.nextInt(7);
            for(;;){
                if(unNombre.add(RandNum)) break;
                else RandNum = NumRend.nextInt(7);
            }
            if(i > liste_personnage.ensPersonnage.size()){
                break;
            }else{
                NomPerso = liste_personnage.getNomP(RandNum);
                identifier= getResources().getIdentifier(NomPerso, "drawable", getPackageName());
                //  break;
            }

            switch (i){
                case 1: imageperso.setImageResource(identifier);
                    System.out.println(RandNum + " " + NomPerso);
                    break;
                case 2: imageperso1.setImageResource(identifier);
                    System.out.println(RandNum + " " + NomPerso);
                    break;
                case 3: imageperso2.setImageResource(identifier);
                    System.out.println(RandNum + " " + NomPerso);
                    break;
                case 4: imageperso3.setImageResource(identifier);
                    System.out.println(RandNum + " " + NomPerso);
                    break;
                case 5: imageperso4.setImageResource(identifier);
                    System.out.println(RandNum + " " + NomPerso);
                    break;
                case 6: imageperso5.setImageResource(identifier);
                    System.out.println(RandNum + " " + NomPerso);
                    break;
                case 7: imageperso6.setImageResource(identifier);
                    System.out.println(RandNum + " " + NomPerso);
                    break;

            }


        }
    }


    public void launchNiveau(int wSeconde)
    {


        /*
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        long randomposition = (long) (Math.random() * metrics.widthPixels * (Math.random() > 0.5 ? 1 : -1));
        long randomposition2 = (long) (Math.random() * metrics.heightPixels * (Math.random() > 0.5 ? 1 : -1));
        Animation animation = new TranslateAnimation(0, randomposition, 0,randomposition2);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        imageperso.startAnimation(animation);*/




        //L'image du chronomètre apparait
        imgChrono.setVisibility(View.VISIBLE);

        //Le bouton abandonner apparait
        btnAbandonner.setVisibility(View.VISIBLE);

        //Le message de fin est invisible
        txtMessageFin.setVisibility(View.INVISIBLE);

        //Instancie le timer
        countDownTimer = new CountDownTimer(wSeconde * 1000, 1000) {

            //Evènement qui se passe pendant que le timer est en cours
            /*
            public void onTick(long millisUntilFinished) {

                txtTimer.setText(" " + millisUntilFinished / 1000);

            }
*/
            //Evènement qui se passe pendant que le timer est en cours
            public void onTick(long millisUntilFinished) {
                int minutes = (int) millisUntilFinished / 60000;
                int seconds = (int) millisUntilFinished % 60000 / 1000;

                String timeLeftText;

                timeLeftText = "" +minutes;
                timeLeftText += ":";
                if (seconds<10) timeLeftText += "0";
                timeLeftText += seconds;


                //txtTimer.setText(" " + millisUntilFinished / 1000);
                txtTimer.setText(timeLeftText);

            }

            //Lorsque le timer est à 0
            public void onFinish() {

                //Indique que le temps est imparti, et cache le bouton abandonner
                txtTimer.setText("Fin");
                btnAbandonner.setVisibility(View.INVISIBLE);

                //L'image a trouver devient un point d'intégoration, et le texte correspondant a l'image est reinistialisé
                imgAtrouver.setImageResource(R.drawable.pointinterogation);
                txtTest.setText("");

                //Les boutons de niveaux sont de nouveau clicquable
                btnNiveau1.setEnabled(true);
                btnNiveau2.setEnabled(true);
                btnNiveau3.setEnabled(true);

            }

        };

        //Les boutons de niveaux sont désactivé au lancement d'un niveau
        btnNiveau1.setEnabled(false);
        btnNiveau2.setEnabled(false);
        btnNiveau3.setEnabled(false);


        countDownTimer.start();
    }




}
