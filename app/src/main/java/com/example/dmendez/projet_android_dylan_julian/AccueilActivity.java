package com.example.dmendez.projet_android_dylan_julian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AccueilActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageJeu1;
    private ImageView imageJeu2;
    private EditText editTextPrenom;
    private String lePrenom;

    private collectionPersonnage liste_personnage = new collectionPersonnage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        imageJeu1 = (ImageView) this.findViewById(R.id.imageView_Jeu1);
        imageJeu2 = (ImageView) this.findViewById(R.id.imageView_Jeu2);
        editTextPrenom = (EditText) this.findViewById(R.id.editText_prenom);

        imageJeu1.setOnClickListener(this);
        imageJeu2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent unIntent = new Intent(this, MainActivity.class);
        lePrenom = editTextPrenom.getText().toString();
        unIntent.putExtra("Joueur", lePrenom);

        if(lePrenom.isEmpty()){
            Toast toast =  Toast.makeText(this, "Il manque le prénom !", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.TOP|Gravity.LEFT, 1100, 500);
            toast.show();
        }
        else {
            this.startActivity(unIntent);
        }
    }
}
