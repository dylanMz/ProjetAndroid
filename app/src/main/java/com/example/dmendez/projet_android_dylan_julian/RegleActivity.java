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

import org.w3c.dom.Text;

public class RegleActivity extends Activity implements View.OnClickListener{

    private int nbRegle;
    private Button btnRetour;
    private ImageView imageFlecheDroite;
    private ImageView imageFlecheGauche;
    private ImageView imageJeu;
    private ImageView imageJeu2;
    private TextView txtRegle;
    private TextView txtAideChrono;
    private TextView txtAidePerso;
    private TextView txtAideZone;
    private TextView txtAideTick;
    private TextView txtAideBarre;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regle);

        btnRetour = (Button) this.findViewById(R.id.button_retour2);
        imageFlecheDroite = (ImageView) this.findViewById(R.id.imageView_flechedroite);
        imageFlecheGauche = (ImageView) this.findViewById(R.id.imageView_flechegauche);
        imageJeu = (ImageView) this.findViewById(R.id.imageView_jeuScreen);
        imageJeu2 = (ImageView) this.findViewById(R.id.imageView_jeuScreen2);
        txtRegle = (TextView) this.findViewById(R.id.textView_regle);
        txtAideChrono = (TextView) this.findViewById(R.id.textView_regleChrono);
        txtAidePerso = (TextView) this.findViewById(R.id.textView_reglePersoARetrouver);
        txtAideZone = (TextView) this.findViewById(R.id.textView_regleZone);
        txtAideTick = (TextView) this.findViewById(R.id.textView_regleTick);
        txtAideBarre = (TextView) this.findViewById(R.id.textView_regleBarre);

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
                nbRegle = nbRegle + 1;

                if (nbRegle == 1){
                    regle2();

                }

                if(nbRegle == 2 ){
                    regle3();
                }

                if(nbRegle == 3){
                    regle4();
                    imageFlecheDroite.setVisibility(View.INVISIBLE);

                }

            }
        });

        //Permet de passer à la règle précédente
        imageFlecheGauche.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                nbRegle = nbRegle - 1;

                if(nbRegle == 0){
                    regle1();
                    imageFlecheDroite.setVisibility(View.VISIBLE);


                }
                if(nbRegle == 1){
                    regle2();
                    imageFlecheDroite.setVisibility(View.VISIBLE);

                }

                if(nbRegle == 2){
                    regle3();
                    imageFlecheDroite.setVisibility(View.VISIBLE);


                }


            }
        });

    }

    public void regle1(){

        txtRegle.setText("1/ Pour commencer, choisir un niveau");

        imageJeu.setVisibility(View.VISIBLE);

        imageFlecheGauche.setVisibility(View.INVISIBLE);
        imageJeu2.setVisibility(View.INVISIBLE);
        txtAideChrono.setVisibility(View.INVISIBLE);
        txtAidePerso.setVisibility(View.INVISIBLE);
        txtAideZone.setVisibility(View.INVISIBLE);
        txtAideTick.setVisibility(View.INVISIBLE);
        txtAideTick.setVisibility(View.INVISIBLE);
        txtAideBarre.setVisibility(View.INVISIBLE);

    }
    public void regle2(){
        txtRegle.setText("2/ Trouver tous les personnages le plus rapidement possibles !");
        imageJeu2.setImageResource(R.drawable.imgappli2);
        imageJeu.setVisibility(View.INVISIBLE);
        txtAideTick.setVisibility(View.INVISIBLE);
        txtAideBarre.setVisibility(View.INVISIBLE);

        imageJeu2.setVisibility(View.VISIBLE);
        imageFlecheGauche.setVisibility(View.VISIBLE);
        txtAideChrono.setVisibility(View.VISIBLE);
        txtAidePerso.setVisibility(View.VISIBLE);
        txtAideZone.setVisibility(View.VISIBLE);
    }
    public void regle3(){
        imageJeu2.setImageResource(R.drawable.imgappli4);
        txtAideChrono.setVisibility(View.INVISIBLE);
        txtAidePerso.setVisibility(View.INVISIBLE);
        txtAideZone.setVisibility(View.INVISIBLE);

        txtAideTick.setVisibility(View.VISIBLE);
        txtAideBarre.setVisibility(View.VISIBLE);

        txtRegle.setText("");
    }
    public void regle4(){
        imageJeu2.setImageResource(R.drawable.imgappli3);

        txtAideTick.setVisibility(View.INVISIBLE);
        txtAideBarre.setVisibility(View.INVISIBLE);

        txtRegle.setVisibility(View.VISIBLE);
        txtAideZone.setVisibility(View.VISIBLE);

        txtRegle.setText("3/ Partie fini, pour recommencer clique sur un niveau");
        txtAideZone.setText("Message de fin contenant ton score, ton temps, tu peux aussi consulter les meilleurs scores");
    }

    @Override
    public void onClick(View view) {

    }
}
