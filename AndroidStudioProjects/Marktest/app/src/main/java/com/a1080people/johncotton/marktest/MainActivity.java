package com.a1080people.johncotton.marktest;


import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Chronometer timecode;
    Boolean isRunning = false;
    Button mark_button;
    Button stop_button;
    Button scene_plus;
    Button scene_minus;
    Button shot_plus;
    Button shot_minus;
    Button take_plus;
    Button take_minus;
    ImageView syncImage;
    MediaPlayer cueBlipmp;
    public Integer sceneStepperValue = 1;
    public Integer shotStepperValue = 1;
    public Integer takeStepperValue = 1;
    TextView scene;
    TextView shot;
    TextView take;
    public String sceneStepperString = "1";
    public String shotStepperString = "1";
    public String takeStepperString = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cueBlipmp = MediaPlayer.create(this, R.raw.cueblip);
        syncImage = (ImageView) findViewById(R.id.imageView2);
        mark_button = (Button) findViewById(R.id.button);
        stop_button = (Button) findViewById(R.id.button2);
        scene_plus = (Button) findViewById(R.id.scenePlus);
        scene_minus = (Button) findViewById(R.id.sceneMinus);
        shot_plus = (Button) findViewById(R.id.shotPlus);
        shot_minus = (Button) findViewById(R.id.shotMinus);
        take_plus = (Button) findViewById(R.id.takePlus);
        take_minus = (Button) findViewById(R.id.takeMinus);
        scene = (TextView) findViewById(R.id.scene);
        shot = (TextView) findViewById(R.id.shot);
        take = (TextView) findViewById(R.id.take);
        timecode = (Chronometer) findViewById(R.id.chronometer2);
        syncImage.setVisibility(View.INVISIBLE);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/dsdigi.TTF");
        timecode.setTypeface(custom_font);




    }


    public void startClock(View view) {

        timecode.setBase(SystemClock.elapsedRealtime());
        timecode.start();
        cueBlipmp.start();
        isRunning = true;
        syncImage.setVisibility(View.VISIBLE);
        syncImage.postDelayed(new Runnable() {
            public void run() {
                syncImage.setVisibility(View.INVISIBLE);
            }
        }, 100);
    }
    public void stopButton(View view) {
        if (isRunning) {
            timecode.stop();
            isRunning = false;
        } else
            timecode.setBase(SystemClock.elapsedRealtime());
    }

    public void SceneStepperPlus(View view) {
        if (sceneStepperValue < 99){
            sceneStepperValue ++;
            sceneStepperString = Integer.toString(sceneStepperValue);
            scene.setText(sceneStepperString);
        }
    }
    public void SceneStepperMinus(View view) {
        if (sceneStepperValue > 1){
            sceneStepperValue --;
            sceneStepperString = Integer.toString(sceneStepperValue);
            scene.setText(sceneStepperString);
        }
    }
    public void ShotStepperPlus(View view) {
        if (shotStepperValue < 99){
            shotStepperValue ++;
            shotStepperString = Integer.toString(shotStepperValue);
            shot.setText(shotStepperString);
        }
    }
    public void ShotStepperMinus(View view) {
        if (shotStepperValue > 1){
            shotStepperValue --;
            shotStepperString = Integer.toString(shotStepperValue);
            shot.setText(sceneStepperString);
        }
    }
    public void TakeStepperPlus(View view) {
        if (takeStepperValue < 99){
            takeStepperValue ++;
            takeStepperString = Integer.toString(takeStepperValue);
            take.setText(takeStepperString);
        }
    }
    public void TakeStepperMinus(View view) {
        if (takeStepperValue > 1){
            takeStepperValue --;
            takeStepperString = Integer.toString(takeStepperValue);
            take.setText(takeStepperString);
        }
    }
}
