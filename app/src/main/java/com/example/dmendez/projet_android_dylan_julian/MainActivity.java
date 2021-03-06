package com.example.dmendez.projet_android_dylan_julian;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.support.constraint.ConstraintLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.*;

public class MainActivity extends Activity implements View.OnClickListener {
    private ProgressBar progressBarJeu1;

    private ConstraintLayout frmImages;


    String URLServeur ="http://juliandemois.alwaysdata.net/bdd_inserer_score.php";
    ProgressDialog pDialog ;
    private float cordx;
    private float cordy;

    private String NomPerso;
    private String lePrenom;
    private String timeLeftText;
    private String leNiveau;

    private Button btnNiveau1;
    private Button btnNiveau2;
    private Button btnNiveau3;
    private Button btnNiveau4;

    private Button btnAbandonner;
    private Button btnReprendre;
    private Button btnArreter;
    private Button btnScore;
    private Button btnAccueil;

    private TextView txtAccueilMsg;
    private TextView txtTest;
    private TextView txtTimer;
    private TextView txtMessageFin;
    private TextView txtTrouveLe;
    private TextView txtScore;

    private ImageView imgTick;

    //les images des personnages
    private ImageView imgAtrouver;
    private ImageView imgAtrouver2;
    private ImageView imgChrono;
    private ImageView imageperso;
    private ImageView imageperso1;
    private ImageView imageperso2;
    private ImageView imageperso3;
    private ImageView imageperso4;
    private ImageView imageperso5;
    private ImageView imageperso6;
    private ImageView imageperso7;
    private ImageView imageperso8;
    private ImageView imageperso9;
    private ImageView imageperso10;
    private ImageView imageperso11;
    private ImageView imageperso12;
    private ImageView imageperso13;
    private ImageView imageperso14;
    private ImageView imageperso15;
    private ImageView imageperso16;
    private ImageView imageperso17;
    private ImageView imageperso18;
    private ImageView imageperso19;
    private ImageView imageperso20;
    private ImageView imageperso21;
    private ImageView imageperso22;
    private ImageView imageperso23;
    private ImageView imageperso24;
    private ImageView imageperso25;
    private ImageView imageperso26;
    private ImageView imageperso27;
    private ImageView imageperso28;

    private int totalimageatrouver = 29;


    private int identifier;
    private int uneSeconde;
    private int unScore;
    private int maxTab[];
    private int NUMimageatrouver = 0;
    private int nbPerso;
    private int minutes;
    private int seconds;
    private int minutesR;
    private int secondsR;
    private long TempsTimer;
    private int minuteRestante;
    private String lNomPerso;
    private String nomTheme;
    private String nomimage;
    private String nomPerso;
    private int RandNumtout;

    //les timers
    private CountDownTimer countDownTimer;
    private CountDownTimer countDownTimer2;
    private CountDownTimer countDownTimerErreur;
    private CountDownTimer countDownTimerTick;

    private MediaPlayer bonneRep;
    private MediaPlayer mauvaiseRep;

    private boolean isPaused = false;




    private collectionPersonnage liste_personnage = new collectionPersonnage();
    private collectionThemes liste_themes = new collectionThemes();
    //private collectionScore liste_score = new collectionScore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initilisation des controles android studio
        txtAccueilMsg = (TextView) this.findViewById(R.id.textView_msgAccueil);
        btnNiveau1 = (Button) this.findViewById(R.id.button_niveau1);
        btnNiveau2 = (Button) this.findViewById(R.id.button_niveau2);
        btnNiveau3 = (Button) this.findViewById(R.id.button_niveau3);
        btnNiveau4 = (Button) this.findViewById(R.id.button_niveau4);

        txtTimer = (TextView) this.findViewById(R.id.textView_timer);
        imgAtrouver = (ImageView) this.findViewById(R.id.imageView_persoChercher);
        imgAtrouver2 = (ImageView) this.findViewById(R.id.imageView_persoChercher2);
        txtTest = (TextView) this.findViewById(R.id.textView_test);
        btnAbandonner = (Button) this.findViewById(R.id.button_abandonner);
        btnReprendre = (Button) this.findViewById(R.id.button_repndre);
        btnArreter = (Button) this.findViewById(R.id.button_arreter);
        txtMessageFin = (TextView) this.findViewById(R.id.textView_messageFin);
        imgChrono = (ImageView) this.findViewById(R.id.imageView_chrono);
        imageperso = (ImageView) this.findViewById(R.id.imageView_perso);
        imageperso1 = (ImageView) this.findViewById(R.id.imageView_perso1);
        imageperso2 = (ImageView) this.findViewById(R.id.imageView_perso2);
        imageperso3 = (ImageView) this.findViewById(R.id.imageView_perso3);
        imageperso4 = (ImageView) this.findViewById(R.id.imageView_perso4);
        imageperso5 = (ImageView) this.findViewById(R.id.imageView_perso5);
        imageperso6 = (ImageView) this.findViewById(R.id.imageView_perso6);
        imageperso7 = (ImageView) this.findViewById(R.id.imageView_perso7);
        imageperso8 = (ImageView) this.findViewById(R.id.imageView_perso8);
        imageperso9 = (ImageView) this.findViewById(R.id.imageView_perso9);
        imageperso10 = (ImageView) this.findViewById(R.id.imageView_perso10);
        imageperso11 = (ImageView) this.findViewById(R.id.imageView_perso11);
        imageperso12 = (ImageView) this.findViewById(R.id.imageView_perso12);
        imageperso13 = (ImageView) this.findViewById(R.id.imageView_perso13);
        imageperso14 = (ImageView) this.findViewById(R.id.imageView_perso14);
        imageperso15 = (ImageView) this.findViewById(R.id.imageView_perso15);
        imageperso16 = (ImageView) this.findViewById(R.id.imageView_perso16);
        imageperso17 = (ImageView) this.findViewById(R.id.imageView_perso17);
        imageperso18 = (ImageView) this.findViewById(R.id.imageView_perso18);
        imageperso19 = (ImageView) this.findViewById(R.id.imageView_perso19);
        imageperso20 = (ImageView) this.findViewById(R.id.imageView_perso20);
        imageperso21 = (ImageView) this.findViewById(R.id.imageView_perso21);
        imageperso22 = (ImageView) this.findViewById(R.id.imageView_perso22);
        imageperso23 = (ImageView) this.findViewById(R.id.imageView_perso23);
        imageperso24 = (ImageView) this.findViewById(R.id.imageView_perso24);
        imageperso25 = (ImageView) this.findViewById(R.id.imageView_perso25);
        imageperso26 = (ImageView) this.findViewById(R.id.imageView_perso26);
        imageperso27 = (ImageView) this.findViewById(R.id.imageView_perso27);
        imageperso28 = (ImageView) this.findViewById(R.id.imageView_perso29);
        txtTrouveLe = (TextView) this.findViewById(R.id.textView_msg);
        txtScore = (TextView) this.findViewById(R.id.textView_score);
        frmImages = (ConstraintLayout) this.findViewById(R.id.constraintLayout_images);
        progressBarJeu1 = (ProgressBar) this.findViewById(R.id.progressBar_score);
        imgTick = (ImageView) this.findViewById(R.id.imageView_tick);
        btnScore = (Button) this.findViewById(R.id.button_score);
        btnAccueil = (Button) this.findViewById(R.id.button_home);

        this.bonneRep = MediaPlayer.create(getApplicationContext(), R.raw.bonne_rep);
        this.mauvaiseRep = MediaPlayer.create(getApplicationContext(), R.raw.mauvaise_rep);

        final ImageView[] imagePersoList = {imageperso,imageperso1,imageperso2,imageperso3,imageperso4,imageperso5,imageperso6,imageperso7,imageperso8,imageperso9,imageperso10,imageperso11,imageperso12,imageperso13,imageperso14,imageperso15,imageperso16,imageperso17,imageperso18,imageperso19,imageperso20,imageperso21,imageperso22,imageperso23,imageperso24,imageperso25,imageperso26,imageperso27,imageperso28};
        for(int i = 0; i<imagePersoList.length;i++){
            imagePersoList[i].setEnabled(false);
            imagePersoList[i].setOnClickListener(this);
        }

        txtMessageFin.setVisibility(View.INVISIBLE);

        //Recupère le prénom du joueur
        lePrenom = this.getIntent().getExtras().getString("Joueur");

        //Recupère le thème
        nomTheme = this.getIntent().getExtras().getString("theme");

        //Affiche le prénom du joueur
        txtAccueilMsg.setText("Bonne chance " + lePrenom + ", choisi un niveau !");

/*
        FragmentManager fragMana = getFragmentManager();
        FragmentTransaction fragTrans = fragMana.beginTransaction();
        MenuActivity lemenu = new MenuActivity();
        fragTrans.add(R.id.menu_fragment, lemenu);
        fragTrans.commit();*/

        liste_themes.insertion_theme(getApplicationContext());
        liste_personnage.insertion_personnage(getApplicationContext());
        imgAtrouver.setImageResource(R.drawable.pointinterogation);

        //Permet de retourner à l'accueil
        btnAccueil.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent1 = new Intent(MainActivity.this, AccueilActivity.class);
                startActivity(intent1);
            }
        });

        //Lancement du niveau facile
        btnNiveau1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Affecte la valeur 120 a une seconde.
                uneSeconde = 120;
                leNiveau = "Facile";

                //Animation sur le bouton
                btnNiveau1.animate().translationX(400).withLayer();

                //Lance la partie
                launchNiveau(uneSeconde);
                initImage();
            }
        });

        //Lancement du niveau moyen
        btnNiveau2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Affecte la valeur 80 a une seconde.
                uneSeconde = 80;
                leNiveau = "Moyen";

                //Animation sur le bouton
                btnNiveau2.animate().translationX(400).withLayer();

                //Lance la partie
                launchNiveau(uneSeconde);
                initImage();
            }
        });

        //Lancement du niveau difficile
        btnNiveau3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Affecte la valeur 60 a une seconde.
                uneSeconde = 60;
                leNiveau = "Difficile";

                //Animation sur le bouton
                btnNiveau3.animate().translationX(400).withLayer();

                //Lance la partie
                launchNiveau(uneSeconde);
                initImage();
            }
        });

        //Lancement du niveau extreme
        btnNiveau4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Affecte la valeur 45 a une seconde.
                uneSeconde = 45;
                leNiveau = "Extreme";

                //Animation sur le bouton
                btnNiveau4.animate().translationX(400).withLayer();

                //Lance la partie
                launchNiveau(uneSeconde);
                initImage();
            }
        });

        //Permet d'abandonner une partie.
        btnAbandonner.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                frmImages.setVisibility(View.INVISIBLE);
                pause("                Tu as mis la partie en pause !");
                //EndGames("Tu as abandonné... mais c'est pas grave ! tu peux recommencer ! Clique sur un des niveaux !");

            }
        });

        btnReprendre.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                frmImages.setVisibility(View.VISIBLE);
                resum();
                //EndGames("Tu as abandonné... mais c'est pas grave ! tu peux recommencer ! Clique sur un des niveaux !");

            }
        });
        btnArreter.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                EndGames("Tu as abandonné... mais c'est pas grave ! tu peux recommencer ! Clique sur un des niveaux !");

            }
        });



        //Permet d'aller voir le tableau des scores
        btnScore.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent1 = new Intent(MainActivity.this, ScoreActivity.class);
                intent1.putExtra("Joueur", lePrenom);
                intent1.putExtra("theme", nomTheme);
                startActivity(intent1);


            }
        });


    }

    //Méthode affichant les images aléatoirement
    private void initImage()
    {
        TreeSet unNombre = new TreeSet();
        Random NumRend = new Random();
        RandNumtout = NumRend.nextInt(liste_personnage.ensPersonnage.size());
        if(!nomTheme.equals("Tous")){
            liste_personnage.recup_theme(getApplicationContext(), nomTheme);
            maxTab = randomize(liste_personnage.ensPersonnagetheme.size(), liste_personnage.ensPersonnagetheme.size() + 1);
        }else{
            maxTab = randomize(liste_personnage.ensPersonnage.size(), liste_personnage.ensPersonnage.size()+1);
        }

        //Nombre aléatoire sans doublon pour disposer les images aléatoirement sur l'écran


        if(!nomTheme.equals("Tous")){
            //choix d'un theme
            for (int i = 0; i<liste_personnage.ensPersonnagetheme.size(); i++){
                int RandNum = NumRend.nextInt(liste_personnage.ensPersonnagetheme.size());
                lNomPerso = liste_personnage.ensPersonnagetheme.get(i).getNomImage();
                final ImageView[] imagePersoList = {imageperso,imageperso1,imageperso2,imageperso3,imageperso4,imageperso5,imageperso6,imageperso7,imageperso8,imageperso9,imageperso10,imageperso11,imageperso12,imageperso13,imageperso14,imageperso15,imageperso16,imageperso17,imageperso18,imageperso19,imageperso20,imageperso21,imageperso22,imageperso23,imageperso24,imageperso25,imageperso26,imageperso27,imageperso28};

                identifier= getResources().getIdentifier(lNomPerso, "drawable", getPackageName());
                imagePersoList[i].setImageResource(identifier);
                imagePersoList[i].setTag(identifier);
                imagePersoList[i].setEnabled(true);
                imagePersoList[i].setVisibility(View.VISIBLE);
                System.out.println(lNomPerso);
            }
        }else{
            //Thème "Tous"
            for(int i = 0; i<totalimageatrouver; i++){
                int RandNum = NumRend.nextInt(totalimageatrouver);
                for(;;){
                    if(unNombre.add(RandNum)) break;
                    else RandNum = NumRend.nextInt(totalimageatrouver);
                }

                //modifie les propriétés des images dans la liste
                final ImageView[] imagePersoList = {imageperso,imageperso1,imageperso2,imageperso3,imageperso4,imageperso5,imageperso6,imageperso7,imageperso8,imageperso9,imageperso10,imageperso11,imageperso12,imageperso13,imageperso14,imageperso15,imageperso16,imageperso17,imageperso18,imageperso19,imageperso20,imageperso21,imageperso22,imageperso23,imageperso24,imageperso25,imageperso26,imageperso27,imageperso28};

                NomPerso = liste_personnage.getNomImage(maxTab[NUMimageatrouver]);
                identifier= getResources().getIdentifier(NomPerso, "drawable", getPackageName());
                imagePersoList[RandNum].setImageResource(identifier);
                imagePersoList[RandNum].setTag(identifier);
                imagePersoList[RandNum].setEnabled(true);
                imagePersoList[RandNum].setVisibility(View.VISIBLE);
                NUMimageatrouver++;
                if (NUMimageatrouver == totalimageatrouver){
                    NUMimageatrouver = 0;
                }

            }
        }

        ImageaTrouver();

    }

    //Permet de modifier l'image à trouver pendant le déroulement de la partie
    private void ImageaTrouver(){

        System.out.println(maxTab[NUMimageatrouver] + " dd "+ NUMimageatrouver);
        int numatrouver = maxTab[NUMimageatrouver];
        if(!nomTheme.equals("Tous")){
            nomimage = liste_personnage.ensPersonnagetheme.get(numatrouver).getNomImage();
            nomPerso = liste_personnage.ensPersonnagetheme.get(numatrouver).getNomPersonnage();
           // nomimage = liste_personnage.getTheme(numatrouver);
            //nomPerso = liste_personnage.getNomPersotheme(numatrouver);
        }else{
            nomimage = liste_personnage.getNomImage(numatrouver);
            nomPerso = liste_personnage.getNomPerso(numatrouver);
        }

        txtTest.setText(String.valueOf(nomPerso));
        int identifier= getResources().getIdentifier(nomimage, "drawable", getPackageName());

        imgAtrouver.setImageResource(identifier);
        imgAtrouver.setTag(identifier);
        imgAtrouver.setVisibility(View.VISIBLE);
        txtTest.setVisibility(View.VISIBLE);
        NUMimageatrouver++;
    }
    /**
     * Cette méthode génére une séquence de nombre aléatoires deux à deux distincts.
     * L'avantage de cette méthode utilitaire est le fait qu'elle génére des nombres
     * aléatoires distincts deux à deux d'une façon déterministe.
     * Elle évite le besoin de faire des boucles imbriquées pour teste si un tel entier
     * existe déja dans la séquence.
     *
     * Supposons qu'on fournit la valeur 5 comme paramètre à cette méthode,
     * alors celle-ci peut générée la séquence: [0, 4, 3, 1, 2].
     *
     * @param n - Nombre total des éléments de la séquence à générer.
     * @param max - Interval du nombre aléatoire Exemple 0-8.
     * @ return - Retourne la séquence des nombres aléatoires générée.
     */
    public static int[] randomize(int n, int max) {
        int[] returnArray = null;
        if (n > 0) {
            returnArray = new int[max];
            for (int index = 0; index < n; ++index) {
                returnArray[index] = index;
            }
            Random random = new Random(System.currentTimeMillis());
            for (int index = 0; index < n; ++index) {
                int j = (int) (random.nextDouble() * (n - index) + index);
                int tmp = returnArray[index];
                returnArray[index] = returnArray[j];
                returnArray[j] = tmp;
            }
        }
        return returnArray;
    }



    public void launchNiveau(int wSeconde)
    {
        unScore = 0;
        isPaused = false;

        txtTimer.setTextColor(Color.WHITE);

        //Les images apparaissent
        frmImages.setVisibility(View.VISIBLE);

        //L'image du chronomètre apparait
        imgChrono.setVisibility(View.VISIBLE);

        //Le bouton abandonner apparait
        btnAbandonner.setVisibility(View.VISIBLE);

        //Le bouton des scores disparait
        btnScore.setVisibility(View.INVISIBLE);

        //Le message de fin est invisible
        txtMessageFin.setVisibility(View.INVISIBLE);

        //Instancie le timer
        countDownTimer = new CountDownTimer(wSeconde * 1000, 1000) {

            //Evènement qui se passe pendant que le timer est en cours
            public void onTick(long millisUntilFinished) {

                if(isPaused)
                {
                    cancel();
                }else {
                    minutes = (int) millisUntilFinished / 60000;
                    seconds = (int) millisUntilFinished % 60000 / 1000;

                    timeLeftText = "" +minutes;
                    timeLeftText += ":";
                    if (seconds<10) timeLeftText += "0";
                    timeLeftText += seconds;
                    TempsTimer = millisUntilFinished;
                    txtTimer.setText(timeLeftText);
                    if(seconds <= 10 & minutes == 0){
                        txtTimer.setTextColor(Color.RED);
                    }

                }
            }

            //Lorsque le timer est à 0
            public void onFinish() {
                //Quand le temps est arrivé à 0
                int PersoTrouve = NUMimageatrouver - 1;
                //si un thème est choisi
                if(!nomTheme.equals("Tous")){
                    unScore = PersoTrouve*127;
                    EndGames("Fin de partie tu as pas terminé, tu as trouvé "+ PersoTrouve+"/"+liste_personnage.ensPersonnagetheme.size() + " personnages ! Soit un score total de : " +unScore);
                }else {
                    //Calcule le score du joueur
                    unScore = PersoTrouve*127;
                    EndGames("Fin de partie tu as pas terminé, tu as trouvé "+ PersoTrouve+"/"+totalimageatrouver + " personnages ! Soit un score total de : " +unScore);
                }

                txtTimer.setText("Fin");

            }
        };

        //Les boutons de niveaux sont désactivé au lancement d'un niveau
        btnNiveau1.setEnabled(false);
        btnNiveau2.setEnabled(false);
        btnNiveau3.setEnabled(false);
        btnNiveau4.setEnabled(false);

        progressBarJeu1.setProgress(0);

        countDownTimer.start();
    }

    @Override
    public void onClick(final View view) {
        Object nameImg = view.getTag();
        Object ImgaTrouver = imgAtrouver.getTag();
        System.out.println("okoko" + nameImg + " " + ImgaTrouver);

        //Si l'utilisateur trouve le bon personnage
        if(nameImg.equals(ImgaTrouver)){
            bonneRep.start();
            view.setEnabled(false);
            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);

            //enregistrement de la position avant changement
            cordx = view.getX();
            cordy = view.getY();

            //animation de l'image
            view.animate().x(imgAtrouver2.getX()).y(imgAtrouver2.getY()).setDuration(500).start();

            //Affiche le tick vert pour montrer que l'utilisateur a choisi le bon personnage.
            imgTick.setVisibility(View.VISIBLE);

            //Instancie le timer correspondant au tick vert qui indique que l'utilisateur a trouvé le bon personnage
            countDownTimerTick = new CountDownTimer(1 * 1000, 1000) {

                //Evènement qui se passe pendant que le timer est en cours
                public void onTick(long millisUntilFinished) {

                    imgTick.setVisibility(View.VISIBLE);
                }

                //Lorsque le timer est à 0
                public void onFinish() {

                    imgTick.setVisibility(View.INVISIBLE);
                }
            };

            countDownTimerTick.start();


            if (!nomTheme.equals("Tous")){
                //si un theme est choisi
                //Detecte si la partie est fini ou non!
                if(NUMimageatrouver == liste_personnage.ensPersonnagetheme.size()){

                    view.animate().x(cordx).y(cordy).setDuration(0).start();

                    countDownTimer.cancel();
                    seconds = seconds -1;
                    //Indique que le temps est imparti, et cache le bouton abandonner
                    long totaltemps = (minutes*60)+seconds;

                    long tempsfin = uneSeconde - totaltemps;
                    System.out.println(totaltemps + " " + tempsfin);
                    minutesR = (int) tempsfin / 60;
                    secondsR = (int) tempsfin % 60;

                    //donne le nombre de point en fontion du temps restant
                    if(minutes == 0){
                        unScore = liste_personnage.ensPersonnagetheme.size()*127 + 35 * seconds;
                    }else{
                        unScore = liste_personnage.ensPersonnagetheme.size()*127 + 35 * seconds + 2100 * minutes;
                    }
                    if (minutesR == 0){
                        EndGames("Fin de partie tu as terminé en " + secondsR + " secondes, Soit un score total de : "+unScore);


                    }else{
                        EndGames("Fin de partie tu as terminé en " + minutesR + ":" + secondsR + " minutes, Soit un score total de : "+unScore);
                    }
                }else{
                    //met l'image invisible et désactivé aprés l'animation
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ImageaTrouver();

                            view.setVisibility(View.INVISIBLE);

                            view.animate().x(cordx).y(cordy).setDuration(0).start();

                        }
                    }, 500);


                }
            }else{

                //Detecte si la partie est fini ou non!
                if(NUMimageatrouver == 29){

                    view.animate().x(cordx).y(cordy).setDuration(0).start();

                    countDownTimer.cancel();
                    seconds = seconds -1;
                    //Indique que le temps est imparti, et cache le bouton abandonner
                    long totaltemps = (minutes*60)+seconds;

                    long tempsfin = uneSeconde - totaltemps;
                    System.out.println(totaltemps + " " + tempsfin);
                    minutesR = (int) tempsfin / 60;
                    secondsR = (int) tempsfin % 60;

                    //donne le nombre de point en fontion du temps restant
                    if(minutes == 0){
                        unScore = totalimageatrouver*127 + 35 * seconds;
                    }else{
                        unScore = totalimageatrouver*127 + 35 * seconds + 2100 * minutes;
                    }
                    if (minutesR == 0){
                        EndGames("Fin de partie tu as terminé en " + secondsR + " secondes, Soit un score total de : "+unScore);


                    }else{
                        EndGames("Fin de partie tu as terminé en " + minutesR + ":" + secondsR + " minutes, Soit un score total de : "+unScore);
                    }
                }else{
                    //met l'image invisible et désactivé aprés l'animation
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ImageaTrouver();

                            view.setVisibility(View.INVISIBLE);

                            view.animate().x(cordx).y(cordy).setDuration(0).start();

                        }
                    }, 500);


                }
             }

            //Récupère le nombre de personnage
            if(!nomTheme.equals("Tous")){
                nbPerso = liste_personnage.ensPersonnagetheme.size();
            }else{
                nbPerso = totalimageatrouver;
            }


            //Le maxixum de la barre de progression devient le nombre de personnage
            progressBarJeu1.setMax(nbPerso);

            int progressActuel = progressBarJeu1.getProgress();

            if(progressBarJeu1.getProgress() < nbPerso){

                progressActuel = progressActuel+1;
                progressBarJeu1.setProgress(progressActuel);

            }


        }
        //Sinon, quand l'utilisateur se trompe :
        else{
            mauvaiseRep.start();
            //Stop le timer
            countDownTimer.cancel();

            //Récupère les secondes du timer et de la minute si il y en a une
            String leTempsChaine = txtTimer.getText().toString();
            String secondesRestanteDiminué = leTempsChaine.substring(0,1);
            String secondesRestanteDiminué1 = leTempsChaine.substring(leTempsChaine.length()-1);
            String secondesRestanteDiminué2 = leTempsChaine.substring(2,3);

            //Concatènation des secondes et transformation en int
            final String secondesEnsemble = secondesRestanteDiminué2 + secondesRestanteDiminué1;

            if(Integer.parseInt(secondesRestanteDiminué) == 1){
                minuteRestante=60;
            }
            else {
                minuteRestante=0;
            }

            int secondesEnsembleFinal = Integer.parseInt(secondesEnsemble) - 4;
            int minutesScondesRestante = minuteRestante + secondesEnsembleFinal;

            //Instancie un nouveau timer avec l'ancien temps et le malus. (Car l'utilisateur s'est trompé de personnage.)
            countDownTimer = new CountDownTimer(minutesScondesRestante*1000 , 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    if(isPaused)
                    {
                        cancel();
                    }else {
                        minutes = (int) millisUntilFinished / 60000;
                        seconds = (int) millisUntilFinished % 60000 / 1000;

                        timeLeftText = "" +minutes;
                        timeLeftText += ":";

                        if (seconds<10) timeLeftText += "0";
                        timeLeftText += seconds;

                        txtTimer.setText(timeLeftText);
                        if(seconds <= 10 & minutes == 0){
                            txtTimer.setTextColor(Color.RED);
                    }
                    }

                }

                @Override
                public void onFinish() {
                    //Quand le temps est arrivé à 0
                    int PersoTrouve = NUMimageatrouver - 1;

                    if(!nomTheme.equals("Tous")){
                        unScore = PersoTrouve*127;
                        EndGames("Fin de partie tu as pas terminé, tu as trouvé "+ PersoTrouve+"/"+liste_personnage.ensPersonnagetheme.size() + " personnages ! Soit un score total de : " +unScore);
                    }else {
                        //Calcule le score du joueur
                        unScore = PersoTrouve*127;
                        EndGames("Fin de partie tu as pas terminé, tu as trouvé "+ PersoTrouve+"/"+totalimageatrouver + " personnages ! Soit un score total de : " +unScore);
                    }



                    txtTimer.setText("Fin");

                }
            };

            //Lance le timer
            countDownTimer.start();

            //Instancie le timer
            countDownTimerErreur = new CountDownTimer(1 * 1000, 1000) {

                //Evènement qui se passe pendant que le timer est en cours
                public void onTick(long millisUntilFinished) {

                    txtScore.setVisibility(View.VISIBLE);

                }

                //Lorsque le timer est à 0
                public void onFinish() {

                    txtScore.setVisibility(View.INVISIBLE);
                }
            };

            countDownTimerErreur.start();


        }

    }

    //Methode pour la remise à zero de la partie!
    public void EndGames(String MessageFin){
        btnArreter.setVisibility(View.INVISIBLE);
        btnReprendre.setVisibility(View.INVISIBLE);
        //Les boutons de niveau sont de nouveaux cliquable
        btnNiveau1.setEnabled(true);
        btnNiveau2.setEnabled(true);
        btnNiveau3.setEnabled(true);
        btnNiveau4.setEnabled(true);

        //Le personnage à retrouver devient un point d'intégoration et les images sont cachées
        frmImages.setVisibility(View.INVISIBLE);

        txtMessageFin.setVisibility(View.VISIBLE);
        txtMessageFin.setText(MessageFin);

        //Le bouton abandonner disparait et le timer et remis à zero
        btnAbandonner.setVisibility(View.INVISIBLE);
        txtTimer.setText("");

        //Le bouton pour afficher les scores apparait
        btnScore.setVisibility(View.VISIBLE);

        //Cache les composants
        imgAtrouver.setVisibility(View.INVISIBLE);
        txtTest.setVisibility(View.INVISIBLE);
        imgChrono.setVisibility(View.INVISIBLE);
        txtScore.setVisibility(View.INVISIBLE);
        txtTest.setText("");
        imgTick.setVisibility(View.INVISIBLE);

        //Animation lors du clique sur l'un des boutons de niveaux.
        btnNiveau1.animate().translationX(0).withLayer();
        btnNiveau2.animate().translationX(0).withLayer();
        btnNiveau3.animate().translationX(0).withLayer();
        btnNiveau4.animate().translationX(0).withLayer();

        if(unScore !=0){
            //liste_score.insertion_score(getApplicationContext(),unScore,lePrenom,leNiveau);
            new  Webservice().execute(URLServeur,lePrenom,Integer.toString(unScore),leNiveau);
        }


        //Stop le timer
        countDownTimer.cancel();

        //Reinistialise la progress bar
        progressBarJeu1.setProgress(0);

        //remet à 0 l'image à trouver
        NUMimageatrouver = 0;
    }

    public void pause(String Message){
        isPaused = true;

        txtMessageFin.setVisibility(View.VISIBLE);
        txtMessageFin.setText(Message);

        //Le bouton abandonner disparait et le timer et remis à zero
        btnAbandonner.setVisibility(View.INVISIBLE);
        btnReprendre.setVisibility(View.VISIBLE);
        btnArreter.setVisibility(View.VISIBLE);
    }

    public void resum(){
        txtMessageFin.setVisibility(View.INVISIBLE);
        frmImages.setVisibility(View.VISIBLE);

        //Le bouton abandonner disparait et le timer et remis à zero
        btnAbandonner.setVisibility(View.VISIBLE);
        btnReprendre.setVisibility(View.INVISIBLE);
        btnArreter.setVisibility(View.INVISIBLE);
        isPaused = false;

        countDownTimer.cancel();
        String leTempsChaine = txtTimer.getText().toString();
        String secondesRestanteDiminué = leTempsChaine.substring(0,1);
        String secondesRestanteDiminué1 = leTempsChaine.substring(leTempsChaine.length()-1);
        String secondesRestanteDiminué2 = leTempsChaine.substring(2,3);

        //Concatènation des secondes et transformation en int
        final String secondesEnsemble = secondesRestanteDiminué2 + secondesRestanteDiminué1;

        if(Integer.parseInt(secondesRestanteDiminué) == 1){
            minuteRestante=60;
        }
        else {
            minuteRestante=0;
        }

        int secondesEnsembleFinal = Integer.parseInt(secondesEnsemble);
        int minutesScondesRestante = minuteRestante + secondesEnsembleFinal;

        //Relance le timer après la pause
        countDownTimer = new CountDownTimer(minutesScondesRestante*1000 , 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(isPaused)
                {
                    cancel();
                }else {
                    minutes = (int) millisUntilFinished / 60000;
                    seconds = (int) millisUntilFinished % 60000 / 1000;

                    timeLeftText = "" +minutes;
                    timeLeftText += ":";

                    if (seconds<10) timeLeftText += "0";
                    timeLeftText += seconds;

                    txtTimer.setText(timeLeftText);
                    if(seconds <= 10 & minutes == 0){
                        txtTimer.setTextColor(Color.RED);
                    }
                }

            }

            @Override
            public void onFinish() {
                //Quand le temps est arrivé à 0
                int PersoTrouve = NUMimageatrouver - 1;

                if(!nomTheme.equals("Tous")){
                    unScore = PersoTrouve*127;
                    EndGames("Fin de partie tu as pas terminé, tu as trouvé "+ PersoTrouve+"/"+liste_personnage.ensPersonnagetheme.size() + " personnages ! Soit un score total de : " +unScore);
                }else {
                    //Calcule le score du joueur
                    unScore = PersoTrouve*127;
                    EndGames("Fin de partie tu as pas terminé, tu as trouvé "+ PersoTrouve+"/"+totalimageatrouver + " personnages ! Soit un score total de : " +unScore);
                }


                txtTimer.setText("Fin");

            }
        };

        countDownTimer.start();
    }

    class Webservice  extends AsyncTask< String , Void, String > {
        @Override
        protected void onPreExecute () {

            // affichage de boite de  dialogue
            /*pDialog =new ProgressDialog(MainActivity.this) ;
            pDialog.setMessage("Connexion au serveur .......... " );
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();*/
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Ajout du score", Toast.LENGTH_LONG).show();





        }

        @Override
        protected String doInBackground(String... strings) {

            StringBuilder resultat =new StringBuilder();


            try {

                HttpURLConnection conx ;

                URL url =new URL (strings[0]) ;
                String nom=strings[1] ;
                String score=strings[2] ;
                String niveau = strings[3];




                conx=(HttpURLConnection) url.openConnection();


                conx.setDoInput(true);
                conx.setRequestMethod("POST");
                conx.setRequestProperty("Accept-Charset","UTF-8");
                conx.setConnectTimeout(1000);

                Uri.Builder builder =new Uri.Builder().appendQueryParameter("nom",nom).appendQueryParameter("score",score).appendQueryParameter("niveau",niveau) ;

                String requete =builder.build().getEncodedQuery();

                OutputStream os = conx.getOutputStream() ;
                BufferedWriter writer =new BufferedWriter( new OutputStreamWriter(os,"UTF-8"));
                writer.write(requete);
                writer.flush();
                writer.close();
                os.close();


                conx.connect();
                // recuperation de donnees sous forme string

                InputStream in =new BufferedInputStream(conx.getInputStream());
                BufferedReader reader =new BufferedReader( (new InputStreamReader(in)));

                String ligne ;
                while ((ligne=reader.readLine())!=null ) {
                    resultat.append(ligne) ;
                }

                conx.disconnect();


            }
            catch (IOException e){
                e.printStackTrace();

            }



            return resultat.toString() ;


        }

        @Override
        protected  void onPostExecute (String str) {

            //pDialog.dismiss(); //fermeture de boite de dialogue

            Toast.makeText(getApplicationContext(),str, Toast.LENGTH_LONG).show();




        }


    }





}
