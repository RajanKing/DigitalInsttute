package com.example.digitalinstutie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {


    // varables for animations
    Animation topAnim, bottomAnim;
    ImageView imageView;
    TextView logo, slogon;
    private static int SPLASH_SCREEN_TIME = 5000;//5seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_splash_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_splash_animation);
        imageView = findViewById(R.id.splashlogo);
        logo = findViewById(R.id.splashappname);
        slogon = findViewById(R.id.splashslogon);
        imageView.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogon.setAnimation(bottomAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Login.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_TIME);

    }
}