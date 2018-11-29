package com.example.dmendez.projet_android_dylan_julian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Button btnNiveau1;
    private Button btnNiveau2;
    private Button btnNiveau3;
    private TextView txtAccueilMsg;
    private String lePrenom;
    private TextView txtTimer;
    private int uneSeconde;


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


        //Affiche le prénom du joueur
        lePrenom = this.getIntent().getExtras().getString("Joueur");
        txtAccueilMsg.setText("Bonne chance " + lePrenom + ", choisi un niveau !");

        btnNiveau1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                uneSeconde = 180;
                launchNiveau(uneSeconde);
            }
        });

        btnNiveau2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                uneSeconde = 120;
                launchNiveau(uneSeconde);
            }
        });

        btnNiveau3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                uneSeconde = 60;
                launchNiveau(uneSeconde);
            }
        });
    }

    public void launchNiveau(int wSeconde)
    {
        //Instancie un timer
        final CountDownTimer countDownTimer = new CountDownTimer(wSeconde * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                txtTimer.setText("Temps restant : " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                txtTimer.setText("Fin");
            }



        };

        countDownTimer.start();
    }





}
