package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animalactivity);
        Intent intent = getIntent();
        String message = intent.getStringExtra("i");
        final Animal animal = AnimalList.getAnimal(message) ;



        String imgInfo = animal.getImgFile();
        int hightestLifespan = animal.getHightestLifespan();
        int  gestationPeriod = animal.getGestationPeriod();
        float birthWeight = animal.getBirthWeight();
        int adultWeight = animal.getAdultWeight();
        String conservationStatus =animal.getConservationStatus();

        TextView nomAnimal ;
        nomAnimal = (TextView) findViewById(R.id.name);
        nomAnimal.setText(message);

        ImageView anImage ;
        int img = getResources().getIdentifier(animal.getImgFile(), "drawable", getPackageName());
        anImage = (ImageView) findViewById(R.id.image) ;
        anImage.setImageResource(img);

        TextView espv = (TextView) findViewById(R.id.esp);
        espv.setText("L'esperance de vie est :    "+hightestLifespan+" ans");

        TextView gestp = (TextView) findViewById(R.id.gest);
        gestp.setText("La periode de gestation est :    "+gestationPeriod+" jours");

        TextView poidn = (TextView) findViewById(R.id.poidN);
        poidn.setText("Le poids de naissance  est :    "+birthWeight+" Kg");

        TextView poida = (TextView) findViewById(R.id.poidA);
        poida.setText("Le poids adulte est :    "+adultWeight+" Kg");

        final TextView Edt = (TextView) findViewById(R.id.edt);

        final TextView Stat = (TextView) findViewById(R.id.stat) ;
        Stat.setText("Le statut a ete enregistré comme : "+ animal.getConservationStatus());

        Button button = (Button) findViewById(R.id.btn) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animal.setConservationStatus(Edt.getText().toString());

                //TextView Stat = (TextView) findViewById(R.id.stat) ;
                Stat.setText("Le statut a ete enregistré comme : "+ animal.getConservationStatus());

            }
        });







    }
}