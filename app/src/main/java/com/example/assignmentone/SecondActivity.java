package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity{

    Button homeBtn;
    Button rock;
    Button paper;
    Button scissors;
    TextView welcome;
    TextView currentComputerPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        homeBtn = findViewById(R.id.home_button);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to home page
                Intent firstPage = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(firstPage);
            }

        });
        Intent intObj = getIntent();
        String val1 = intObj.getStringExtra("KEY_ONE");

        welcome = findViewById(R.id.goodluck_tv);
        welcome.setText("Welcome " + val1 + ", Good Luck!");

        TextView currentPlayerPlay = findViewById(R.id.current_player_play);

        currentComputerPlay = findViewById(R.id.current_computer_play);

        rock = findViewById(R.id.rock_button);
        paper = findViewById(R.id.paper_button);
        scissors = findViewById(R.id.scissors_buton);

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPlayerPlay.setText("Rock");
                computerPlay();
                //validate who wins
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPlayerPlay.setText("Paper");
                computerPlay();
            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPlayerPlay.setText("Scissors");
                computerPlay();
            }
        });
    }
    public void computerPlay() {
        double randomValue = Math.random();

        if (randomValue <= 0.33) {
            currentComputerPlay.setText("Rock");
        } else if (randomValue <= 0.66) {
            currentComputerPlay.setText("Paper");
        } else {
            currentComputerPlay.setText("Scissors");
        }
    }
}