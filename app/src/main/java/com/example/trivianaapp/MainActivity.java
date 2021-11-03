package com.example.trivianaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private static final int DELAY = 1000;
    private ImageView main_IMG_question;
    private ProgressBar main_PRG_time;
    private Button[] main_BTN_answers;
    private int clock = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        main_PRG_time.setMax(10);
        main_PRG_time.setProgress(10);
        main_IMG_question.setImageResource(R.drawable.dog);
        main_BTN_answers[0].setOnClic

    }
    private void startTicker(){
        Handler handler = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Log.d("timeTick" , "Tick: " + clock);
                updateProgressBar();
                handler.postDelayed(this , DELAY);
            }
        };
    }

    private void updateProgressBar(){
        main_PRG_time.setProgress(--clock);
    }

    @Override
    protected void onStart(){
        super.onStart();
        startTicker();
    }


    @Override
    protected void onStop(){
        super.onStop();
        stopTicker();
    }

    private void stopTicker(){
        handler.removeC
    }


    private void findViews(){
        main_IMG_question = findViewById(R.id.main_IMG_question);
        main_PRG_time = findViewById(R.id.main_PRG_time);
        main_BTN_answers = new Button[]{
                findViewById(R.id.main_BTN_answer1),
                findViewById(R.id.main_BTN_answer2),
                findViewById(R.id.main_BTN_answer3),
                findViewById(R.id.main_BTN_answer4)

        }
    }
}