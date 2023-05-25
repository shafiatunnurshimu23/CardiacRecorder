package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progress;
    ImageView sp_image;
    TextView sp_text,sp_text2;
    Animation Splash_top,Splash_bottom ,Splash_RL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        sp_image=findViewById(R.id.splash_image);
        sp_text=findViewById(R.id.splash_text);
        sp_text2=findViewById(R.id.splash_text2);

        //animation

        Splash_top = AnimationUtils.loadAnimation(this, R.anim.splash_top);
        Splash_bottom = AnimationUtils.loadAnimation(this, R.anim.splash_bottom);
        Splash_RL=AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        sp_image.setAnimation(Splash_top);
        sp_text.setAnimation(Splash_RL);
        sp_text2.setAnimation(Splash_bottom);

        //animation to image and text


        progressBar=findViewById(R.id.progress_bar);
        //Toast.makeText(SplashScreenActivity.this,"Welcome to CardiacRecorder",Toast.LENGTH_SHORT).show();
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                statApp();
            }
        });
        thread.start();
    }
    public void doWork(){
        for (progress = 0; progress <= 100; progress = progress + 20) {
            try {
                Thread.sleep(500);
                progressBar.setProgress(progress);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void statApp()
    {
        Intent intent=new Intent(SplashScreenActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}