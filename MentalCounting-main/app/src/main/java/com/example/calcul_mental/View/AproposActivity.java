package com.example.calcul_mental.View;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calcul_mental.R;

public class AproposActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apropos);

        TextView textViewapropos = findViewById(R.id.text_apropos);
        textViewapropos.setText("Membre du groupe : Baroux Rodrigue et Paolo Sportelli\n\n\n\n" +
                "Les langues disponibles sont le français et l'anglais\n\n\n\n\n\n\n" +
                "Nous avons fait en sorte qu'un calcul aléatoire apparait lorsque l'on arrive sur la page du jeu et quand l'utilisateur rentre la bonne réponse. Lorsqu'une bonne réponse est saisi le score s'incrémente de 1.\n" +
                "Quand une mauvaise le nombre de vie diminue de 1.\n" +
                "Malheuresement, nous n'avons pas eu le temps d'utiliser la base de données car nous avons des  empêchements en effet Paolo doit effectuer un stage sur Nice et donc prend dans l'avion ce qui a compliqué notre travail sur ce projet\n\n\n");
        Button button = findViewById(R.id.bonton_retour);
        button.setOnClickListener(view -> finish());
    }


}
