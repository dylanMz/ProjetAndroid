package com.example.dmendez.projet_android_dylan_julian;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Group;
import android.transition.Fade;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.*;

public class MainActivity extends Activity implements View.OnClickListener {
    private ProgressBar progressBarJeu1;

    private ConstraintLayout frmImages;
    private float cordx;
    private float cordy;

    private String NomPerso;
    private String lePrenom;
    private String timeLeftText;
    private String leNiveau;

    private Button btnNiveau1;
    private Button btnNiveau2;
    private Button btnNiveau3;
    private Button btnAbandonner;
    private Button btnScore;

    private TextView txtAccueilMsg;
    private TextView txtTest;
    private TextView txtTimer;
    private TextView txtMessageFin;
    private TextView txtTrouveLe;
    private TextView txtScore;

    private ImageView imgTick;
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


    private int identifier;
    private int uneSeconde;
    private int unScore;
    private int nbRandom;
    private int maxTab[];
    private int NUMimageatrouver = 0;
    private int nbPerso;
    private int minutes;
    private int seconds;
    private long TempsTimer;
    private int minuteRestante;

    private CountDownTimer countDownTimer;
    private CountDownTimer countDownTimerErreur;
    private CountDownTimer countDownTimerTick;
    private CountDownTimer countDownTimerUpdate;
    private MediaPlayer SongTimer;
    private Score wScore;


    private collectionPersonnage liste_personnage = new collectionPersonnage();
    private collectionScore liste_score = new collectionScore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initilisation des controles android studio
        txtAccueilMsg = (TextView) this.findViewById(R.id.textView_msgAccueil);
        btnNiveau1 = (Button) this.findViewById(R.id.button_niveau1);
        btnNiveau2 = (Button) this.findViewById(R.id.button_niveau2);
        btnNiveau3 = (Button) this.findViewById(R.id.button_niveau3);
        txtTimer = (TextView) this.findViewById(R.id.textView_timer);
        imgAtrouver = (ImageView) this.findViewById(R.id.imageView_persoChercher);
        imgAtrouver2 = (ImageView) this.findViewById(R.id.imageView_persoChercher2);
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

        this.SongTimer = MediaPlayer.create(getApplicationContext(), R.raw.timer_10);

        final ImageView[] imagePersoList = {imageperso,imageperso1,imageperso2,imageperso3,imageperso4,imageperso5,imageperso6,imageperso7,imageperso8,imageperso9,imageperso10,imageperso11,imageperso12,imageperso13,imageperso14,imageperso15,imageperso16,imageperso17,imageperso18,imageperso19,imageperso20,imageperso21,imageperso22,imageperso23,imageperso24,imageperso25,imageperso26,imageperso27,imageperso28};
        for(int i = 0; i<imagePersoList.length;i++){
            imagePersoList[i].setOnClickListener(this);
        }


        //Affiche le prénom du joueur
        lePrenom = this.getIntent().getExtras().getString("Joueur");
        txtAccueilMsg.setText("Bonne chance " + lePrenom + ", choisi un niveau !");



        liste_personnage.insertion_personnage(getApplicationContext());
        imgAtrouver.setImageResource(R.drawable.pointinterogation);

        btnNiveau1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Affecte la valeur 120 a une seconde.
                uneSeconde = 150;
                leNiveau = "Facile";

                btnNiveau1.animate().translationX(400).withLayer();

                launchNiveau(uneSeconde);
                initImage();
            }
        });

        btnNiveau2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Affecte la valeur 60 a une seconde.
                uneSeconde = 120;
                leNiveau = "Moyen";


                btnNiveau2.animate().translationX(400).withLayer();

                launchNiveau(uneSeconde);
                initImage();
            }
        });

        btnNiveau3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Affecte la valeur 30 a une seconde.
                uneSeconde = 45;
                leNiveau = "Difficle";


                btnNiveau3.animate().translationX(400).withLayer();

                launchNiveau(uneSeconde);
                initImage();
            }
        });


        btnAbandonner.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EndGames("Tu as abandonné... mais c'est pas grave ! tu peux recommencer ! Clique sur un des niveaux !");

            }
        });

        btnScore.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent1 = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(intent1);


            }
        });


    }

    //Méthode affichant les images aléatoirement
    private void initImage()
    {

        SongTimer.reset();
        txtMessageFin.setBackgroundColor(0);
        maxTab = randomize(liste_personnage.ensPersonnage.size(), liste_personnage.ensPersonnage.size() + 1);
        int nbMax = liste_personnage.ensPersonnage.size();

        ImageaTrouver();

        //Nombre aléatoire sans doublon pour disposer les images aléatoirement sur l'écran
        TreeSet unNombre = new TreeSet();
        Random NumRend = new Random();



        for(int i = 0; i<liste_personnage.ensPersonnage.size(); i++){
            int RandNum = NumRend.nextInt(liste_personnage.ensPersonnage.size());
            for(;;){
                if(unNombre.add(RandNum)) break;
                else RandNum = NumRend.nextInt(liste_personnage.ensPersonnage.size());
            }

            final ImageView[] imagePersoList = {imageperso,imageperso1,imageperso2,imageperso3,imageperso4,imageperso5,imageperso6,imageperso7,imageperso8,imageperso9,imageperso10,imageperso11,imageperso12,imageperso13,imageperso14,imageperso15,imageperso16,imageperso17,imageperso18,imageperso19,imageperso20,imageperso21,imageperso22,imageperso23,imageperso24,imageperso25,imageperso26,imageperso27,imageperso28};
                NomPerso = liste_personnage.getNomImage(RandNum);
                identifier= getResources().getIdentifier(NomPerso, "drawable", getPackageName());
            imagePersoList[i].setImageResource(identifier);
            imagePersoList[i].setTag(identifier);
            imagePersoList[i].setEnabled(true);
            imagePersoList[i].setVisibility(View.VISIBLE);

        }
    }
    //Permet de modifier l'image à trouver pendant le déroulement de la partie
    private void ImageaTrouver(){

        System.out.println(maxTab[NUMimageatrouver] + " dd "+ NUMimageatrouver);
        int numatrouver = maxTab[NUMimageatrouver];
        String nomimage = liste_personnage.getNomImage(numatrouver);
        String nomPerso = liste_personnage.getNomPerso(numatrouver);
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
        /*
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        long randomposition = (long) (Math.random() * metrics.widthPixels * (Math.random() > 0.5 ? 1 : -1));
        long randomposition2 = (long) (Math.random() * metrics.heightPixels * (Math.random() > 0.5 ? 1 : -1));
        Animation animation = new TranslateAnimation(0, randomposition, 0,randomposition2);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        imageperso.startAnimation(animation);
        */
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
                    SongTimer.start();

                    SongTimer.setVolume(1,1);
                }
            }

            //Lorsque le timer est à 0
            public void onFinish() {
                //Quand le temps est arrivé à 0
                int PersoTrouve = NUMimageatrouver - 1;

                //Calcule le score du joueur
                //int unScore;
                SongTimer.stop();
                unScore = PersoTrouve*127;
                EndGames("Fin de partie tu as pas terminé, tu as trouvé "+ PersoTrouve+"/"+liste_personnage.ensPersonnage.size() + " personnages ! Soit un score total de : " +unScore);

                txtTimer.setText("Fin");

            }
        };

        //Les boutons de niveaux sont désactivé au lancement d'un niveau
        btnNiveau1.setEnabled(false);
        btnNiveau2.setEnabled(false);
        btnNiveau3.setEnabled(false);

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
            view.setEnabled(false);
            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            long randomposition = (long) (Math.random() * metrics.widthPixels * (Math.random() > 0.5 ? 1 : -1));
            long randomposition2 = (long) (Math.random() * metrics.heightPixels * (Math.random() > 0.5 ? 1 : -1));

            //enregistrement de la position avant changement
            cordx = view.getX();
            cordy = view.getY();
            //animation de l'image
            view.animate().x(imgAtrouver2.getX()).y(imgAtrouver2.getY()).setDuration(1000).start();

            //Affiche le tick vert pour montrer que l'utilisateur a choisi le bon personnage.
            imgTick.setVisibility(View.VISIBLE);

            //Instancie le timer
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


            //Detecte si la partie est fini ou non!
            if(NUMimageatrouver == liste_personnage.ensPersonnage.size()){

                view.animate().x(cordx).y(cordy).setDuration(0).start();

                countDownTimer.onFinish();
                seconds = seconds -1;
                //Indique que le temps est imparti, et cache le bouton abandonner
                long totaltemps = (minutes*60)+seconds;

                long tempsfin = uneSeconde - totaltemps;
                System.out.println(totaltemps + " " + tempsfin);
                minutes = (int) tempsfin / 60;
                seconds = (int) tempsfin % 60;
                if (minutes == 0){
                    unScore = liste_personnage.ensPersonnage.size()*127 + 35 * seconds;
                    EndGames("Fin de partie tu as terminé en " + seconds + " secondes, Soit un score total de : "+unScore);


                }else{
                    unScore = liste_personnage.ensPersonnage.size()*127 + 35 * seconds + 2100 * minutes;
                    EndGames("Fin de partie tu as terminé en " + minutes + ":" + seconds + " minutes, Soit un score total de : "+unScore);
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
                }, 1000);


            }

            //Récupère le nombre de personnage
            nbPerso = liste_personnage.ensPersonnage.size();

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

                    minutes = (int) millisUntilFinished / 60000;
                    seconds = (int) millisUntilFinished % 60000 / 1000;

                    timeLeftText = "" +minutes;
                    timeLeftText += ":";

                    if (seconds<10) timeLeftText += "0";
                    timeLeftText += seconds;

                    txtTimer.setText(timeLeftText);
                    if(seconds <= 10 & minutes == 0){
                        txtTimer.setTextColor(Color.RED);
                        SongTimer.start();
                        SongTimer.setVolume(1, 1);
                    }

                }

                @Override
                public void onFinish() {
                    //Quand le temps est arrivé à 0
                    int PersoTrouve = NUMimageatrouver - 1;

                    //Calcule le score du joueur
                    SongTimer.stop();
                    unScore = PersoTrouve*127;
                    EndGames("Fin de partie tu as pas terminé, tu as trouvé "+ PersoTrouve+"/"+liste_personnage.ensPersonnage.size() + " personnages ! Soit un score total de : " +unScore);

                    txtTimer.setText("Fin");

                }
            };

            countDownTimer.start();

            //Instancie le timer
            countDownTimerErreur = new CountDownTimer(1 * 1000, 1000) {

                //Evènement qui se passe pendant que le timer est en cours
                public void onTick(long millisUntilFinished) {

                    txtScore.setVisibility(View.VISIBLE);

                    //testpourpush

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

        //Les boutons de niveau sont de nouveaux cliquable
        btnNiveau1.setEnabled(true);
        btnNiveau2.setEnabled(true);
        btnNiveau3.setEnabled(true);

        //Le personnage à retrouver devient un point d'intégoration et les images sont cachées
        frmImages.setVisibility(View.INVISIBLE);

        txtMessageFin.setVisibility(View.VISIBLE);
        txtMessageFin.setBackgroundColor(getColor(R.color.colorPrimaryDark));
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

        liste_score.insertion_score(getApplicationContext(),unScore,lePrenom,leNiveau);

        //Stop le timer
        countDownTimer.cancel();

        //Reinistialise la progress bar
        progressBarJeu1.setProgress(0);

        //remet à 0 l'image à trouver
        NUMimageatrouver = 0;
    }





}
