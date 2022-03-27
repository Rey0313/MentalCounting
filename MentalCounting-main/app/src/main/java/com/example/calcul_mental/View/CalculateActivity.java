package com.example.calcul_mental.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calcul_mental.R;
import com.example.calcul_mental.Model.TypeOperationEnum;


import java.util.Random;

public class CalculateActivity extends AppCompatActivity {

    private Integer premierElement = 0;
    private Integer deuxiemeElement = 0;
    private Integer symboleAfficher = new Random().nextInt(3);
    private Integer borne_haute = 1000;
    private Integer reponse=0;
    private TypeOperationEnum typeOperation = null;
    private Menu menu;
    private Integer nbvie=3;
    private Integer nbscore=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        Button button0 = findViewById(R.id.button_0);
        button0.setOnClickListener(view -> ajouterNombre(0));
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(view -> ajouterNombre(1));
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(view -> ajouterNombre(2));
        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(view -> ajouterNombre(3));
        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(view -> ajouterNombre(4));
        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(view -> ajouterNombre(5));
        Button button6 = findViewById(R.id.button_6);
        button6.setOnClickListener(view -> ajouterNombre(6));
        Button button7 = findViewById(R.id.button_7);
        button7.setOnClickListener(view -> ajouterNombre(7));
        Button button8 = findViewById(R.id.button_8);
        button8.setOnClickListener(view -> ajouterNombre(8));
        Button button9 = findViewById(R.id.button_9);
        button9.setOnClickListener(view -> ajouterNombre(9));
        Button button_supprimer = findViewById(R.id.button_supprimer);
        button_supprimer.setOnClickListener(view -> Supprimer());
        Button button_moins = findViewById(R.id.button_negatif);
        button_moins.setOnClickListener(view -> Negatif());
        Button boutonValider=findViewById(R.id.submit_button);
        boutonValider.setOnClickListener(view -> verifReponse(symboleAfficher));

        AfficherCalcul();
    }

    private void Negatif() {
        reponse*=(-1);
        EcrireReponse();
    }

    private void Supprimer() {
        TextView textView_reponse = findViewById(R.id.textView_reponse);
        textView_reponse.setText("Répondez ici");
        reponse=0;
    }

    public void ajouterNombre(int valeur) {
        if (10 * reponse + valeur > borne_haute) {
            Toast.makeText(this, "Valeur trop grande", Toast.LENGTH_LONG).show();
        } else {
            reponse = 10 * reponse + valeur;
        }
        EcrireReponse();
    }

    private void EcrireReponse() {
        String texteAfficher = "";
        TextView textViewReponse = findViewById(R.id.textView_reponse);
        texteAfficher = String.valueOf(reponse);
        textViewReponse.setText(texteAfficher);
    }

    public Integer nvpremierElement() {
        premierElement = premierElement = new Random().nextInt(11);
        return premierElement;

    }

    public Integer nvdeuxiemeElement() {
        deuxiemeElement = deuxiemeElement = new Random().nextInt(11);
        return deuxiemeElement;

    }


    public Integer AfficherCalcul(){
        this.symboleAfficher = new Random().nextInt(3);
        String symbole = "";

        switch(symboleAfficher) {

            case 0:
                symbole = "+";
                break;

            case 1:
                symbole = "-";
                break;

            case 2:
                symbole = "x";
                break;
        }

        TextView CalculAFaire = findViewById(R.id.CalculAFaire);
        CalculAFaire.setText(nvpremierElement() + " " + symbole + " " + nvdeuxiemeElement());
        return symboleAfficher;
    }

    private void verifReponse(Integer symboleAfficher) {
        TextView textView_reponse = findViewById(R.id.textView_reponse);
        String reponse = textView_reponse.getText().toString();
        Integer reponseEnInt = Integer.parseInt(reponse);


        switch(symboleAfficher) {
            case 0:
                if(reponseEnInt == (premierElement + deuxiemeElement)){
                    Toast.makeText(getApplicationContext(),"Bravo !!",Toast.LENGTH_LONG).show();
                    Supprimer();
                    symboleAfficher = new Random().nextInt(3);
                    AfficherCalcul();
                    Score();
                }else{
                    Toast.makeText(getApplicationContext(), "Attention à vos vie",Toast.LENGTH_LONG).show();
                    Supprimer();
                    Vieperdu();

                }
                break;

            case 1:
                if(reponseEnInt == (premierElement-deuxiemeElement)){
                    Toast.makeText(getApplicationContext(),"Bravo !!",Toast.LENGTH_LONG).show();
                    Supprimer();
                    symboleAfficher = new Random().nextInt(3);
                    AfficherCalcul();
                    Score();
                }else{
                    Toast.makeText(getApplicationContext(), "Attention à vos vie",Toast.LENGTH_LONG).show();
                    Supprimer();
                    Vieperdu();

                }
                break;

            case 2:
                if(reponseEnInt == (premierElement*deuxiemeElement)){
                    Toast.makeText(getApplicationContext(),"Bravo !!",Toast.LENGTH_LONG).show();
                    Supprimer();
                    symboleAfficher = new Random().nextInt(3);
                    AfficherCalcul();
                    Score();
                }else{
                    Toast.makeText(getApplicationContext(), "Attention à vos vie",Toast.LENGTH_LONG).show();
                    Supprimer();
                    Vieperdu();

                }
                break;
        }

    }

    public void Vieperdu(){
        MenuItem vie = menu.findItem(R.id.life_count);
        nbvie--;
        if (nbvie!=0){
            String countVie = String.valueOf(nbvie);
            vie.setTitle(countVie);
        }else{
            finish();
        }
    }

    public void Score(){
        MenuItem score = menu.findItem(R.id.score_menu_count);
        nbscore++;
        String countScore = String.valueOf(nbscore);
        score.setTitle(countScore);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);

        this.menu = menu;

        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu_calculate,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.score_menu_button)
        {
            Intent intent = new Intent(this,ScoreActivity.class);
            startActivity(intent);
        }

        if(item.getItemId()==R.id.back_menu_button)
            finish();

        if(item.getItemId()==R.id.delete_menu_button){
            Supprimer();
        }

        return super.onOptionsItemSelected(item);
    }
}