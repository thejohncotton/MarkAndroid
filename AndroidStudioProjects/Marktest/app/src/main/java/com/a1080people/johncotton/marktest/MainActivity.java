package com.a1080people.johncotton.marktest;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Chronometer timecode;
    Boolean isRunning = false;
    Button mark_button;
    Button stop_button;
    ImageView syncImage;
    MediaPlayer cueBlipmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cueBlipmp = MediaPlayer.create(this, R.raw.cueblip);
        syncImage = (ImageView) findViewById(R.id.imageView2);
        mark_button = (Button) findViewById(R.id.button);
        stop_button = (Button) findViewById(R.id.button2);
        timecode = (Chronometer) findViewById(R.id.chronometer2);
        syncImage.setImageAlpha(0);
//        syncImage.setVisibility(View.INVISIBLE);

    }


    public void startClock(View view) {

        timecode.setBase(SystemClock.elapsedRealtime());
        timecode.start();
        cueBlipmp.start();
        isRunning = true;
        syncImage.setImageAlpha(255);
//        syncImage.setVisibility(View.VISIBLE);
        syncImage.animate().alpha(0).setDuration(20);


//        Toast.makeText(getApplicationContext(), "MARK SHOT", Toast.LENGTH_SHORT).show();
    }
    public void stopButton(View view) {
        if (isRunning) {
            timecode.stop();
            //update button text to reset
            //((android.widget.Button)findViewById(R.id.button2).setT‌​ext("Reset");
//          stop_button.setText("Reset");
            isRunning = false;
        } else
            timecode.setBase(SystemClock.elapsedRealtime());
    }


    }
