package com.example.ishope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;
    Animation  animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.logo_app);
        textView = findViewById(R.id.design_by);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        imageView.setAnimation(animation);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        textView.setAnimation(animation);
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                super.run();
            }
        };
        thread.start();

    }
}
