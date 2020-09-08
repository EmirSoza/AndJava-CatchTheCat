package com.emirhan.catchthecat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView scoreText;
    int scoreNum;
    int time;
    Button button;
    Random rand ;
    Handler handler;
    Runnable runnable;
    ImageView[] imageView = new ImageView[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        scoreText = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        imageView[0] = findViewById(R.id.imageView);
        imageView[1] = findViewById(R.id.imageView2);
        imageView[2] = findViewById(R.id.imageView3);
        imageView[3] = findViewById(R.id.imageView4);
        imageView[4] = findViewById(R.id.imageView5);
        imageView[5] = findViewById(R.id.imageView6);
        imageView[6] = findViewById(R.id.imageView7);
        imageView[7] = findViewById(R.id.imageView8);
        imageView[8] = findViewById(R.id.imageView9);

        scoreNum = 0;
        time = 10;

    }

    public void start(View view){
        hideImages();
        scoreNum = 0;
        scoreText.setText("Your score: "+scoreNum);
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                    button.setEnabled(false);
                    textView.setText("Time: "+ millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                handler.removeCallbacks(runnable);
                Toast.makeText(MainActivity.this,"Completed!",Toast.LENGTH_LONG).show();

                for(ImageView image : imageView){
                    image.setVisibility(View.INVISIBLE);
                }
                textView.setText("Time: " +10);
                button.setEnabled(true);

            }
        }.start();


    }

    public  void hideImages(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                 for(ImageView image : imageView){
                     image.setVisibility(View.INVISIBLE);
                 }
                rand = new Random();
                int x = rand. nextInt(9);
                imageView[x].setVisibility(View.VISIBLE);
                handler.postDelayed(runnable,500);
            }
        };


        handler.post(runnable);

    }

    public void score(View view){

        scoreNum++;
        scoreText.setText("Your score: " + scoreNum);
    }
}