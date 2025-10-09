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

//Emojis used
//Rock: \uD83E\uDEA8
//Paper: \uD83D\uDCC3
//Scissors: \u2702\uFE0F

public class SecondActivity extends AppCompatActivity{

    //declare buttons, textview, int, intent...
    Button homeBtn, rock, paper, scissors, restart, shareBtn;
    TextView welcome, currentPlayerPlay, currentComputerPlay, roundWinner, userScore, userLost;
    int score;
    Intent shareObj = new Intent();

    //Home, share and restart buttons
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

        shareBtn = findViewById(R.id.share_button);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareObj.setAction(Intent.ACTION_SEND);
                shareObj.setType("text/plain");

                Intent shareScore = Intent.createChooser(shareObj, null);
                startActivity(shareScore);
            }
        });

        restart = findViewById(R.id.restart_button);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPlayerPlay.setText("");
                currentComputerPlay.setText("");
                userLost.setText("");
                roundWinner.setText("");
                score = 0;
                userScore.setText("Your score: " + score);
            }
        });

        //Get IDs
        Intent intObj = getIntent();
        String val1 = intObj.getStringExtra("KEY_ONE");

        welcome = findViewById(R.id.goodluck_tv);
        welcome.setText("Welcome " + val1 + ", Good Luck!");

        currentPlayerPlay = findViewById(R.id.current_player_play);
        currentComputerPlay = findViewById(R.id.current_computer_play);

        roundWinner = findViewById(R.id.round_winner);

        userLost = findViewById(R.id.you_lost_tv);

        userScore = findViewById(R.id.user_score);

        rock = findViewById(R.id.rock_button);
        paper = findViewById(R.id.paper_button);
        scissors = findViewById(R.id.scissors_buton);

        //Game buttons (rock, paper, scissors)
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPlayerPlay.setText("\uD83E\uDEA8");
                computerPlay();

                if (currentComputerPlay.getText().equals("\uD83E\uDEA8")){
                    roundWinner.setText("Draw");
                    shareObj.putExtra(Intent.EXTRA_TEXT, val1 + "'s score is: " + score);
                }
                else if (currentComputerPlay.getText().equals("\uD83D\uDCC3")){
                    roundWinner.setText("Computer Wins");
                    shareObj.putExtra(Intent.EXTRA_TEXT, val1 + "'s score is: " + score);
                    score = 0;
                    userScore.setText("Your score: " + score);
                    userLost.setText("You Lose!");
                }
                else if (currentComputerPlay.getText().equals("\u2702\uFE0F")){
                    roundWinner.setText("Player Wins");
                    score++;
                    shareObj.putExtra(Intent.EXTRA_TEXT, val1 + "'s score is: " + score);
                    userScore.setText("Your score: " + score);
                }
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPlayerPlay.setText("\uD83D\uDCC3");
                computerPlay();

                if (currentComputerPlay.getText().equals("\uD83D\uDCC3")){
                    roundWinner.setText("Draw");
                    shareObj.putExtra(Intent.EXTRA_TEXT, val1 + "'s score is: " + score);
                }
                else if (currentComputerPlay.getText().equals("\uD83E\uDEA8")){
                    roundWinner.setText("Player Wins");
                    score++;
                    shareObj.putExtra(Intent.EXTRA_TEXT, val1 + "'s score is: " + score);
                    userScore.setText("Your score: " + score);
                }
                else if (currentComputerPlay.getText().equals("\u2702\uFE0F")){
                    roundWinner.setText("Computer Wins");
                    shareObj.putExtra(Intent.EXTRA_TEXT, val1 + "'s score is: " + score);
                    score = 0;
                    userScore.setText("Your score: " + score);
                    userLost.setText("You Lose!");
                }
            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPlayerPlay.setText("\u2702\uFE0F");
                computerPlay();

                if (currentComputerPlay.getText().equals("SCISSORS")){
                    roundWinner.setText("Draw");
                    shareObj.putExtra(Intent.EXTRA_TEXT, val1 + "'s score is: " + score);
                }
                else if (currentComputerPlay.getText().equals("\uD83D\uDCC3")){
                    roundWinner.setText("Player Wins");
                    score++;
                    shareObj.putExtra(Intent.EXTRA_TEXT, val1 + "'s score is: " + score);
                    userScore.setText("Your score: " + score);
                }
                else if (currentComputerPlay.getText().equals("\uD83E\uDEA8")){
                    roundWinner.setText("Computer Wins");
                    shareObj.putExtra(Intent.EXTRA_TEXT, val1 + "'s score is: " + score);
                    score = 0;
                    userScore.setText("Your score: " + score);
                    userLost.setText("You Lose!");
                }
            }
        });
    }

    //computer play method
    public void computerPlay() {
        double randomValue = Math.random();

        if (randomValue < 0.34) {
            currentComputerPlay.setText("\uD83E\uDEA8");
        } else if (randomValue <= 0.67) {
            currentComputerPlay.setText("\uD83D\uDCC3");
        } else {
            currentComputerPlay.setText("\u2702\uFE0F");
        }
    }
}