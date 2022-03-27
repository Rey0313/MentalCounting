package com.example.calcul_mental.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.calcul_mental.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        associateOpenActivityToButton(R.id.play_button, CalculateActivity.class);
        associateOpenActivityToButton(R.id.score_button, ScoreActivity.class);
        associateOpenActivityToButton(R.id.apropos, AproposActivity.class);
    }

    private void associateOpenActivityToButton(int id, Class activity){
        Button mainButton=findViewById(id);
        mainButton.setOnClickListener(view -> openActivity(activity));
    }

    private void openActivity(Class activity) {
        Intent intent = new Intent(this,activity);
        startActivity(intent);
    }
}