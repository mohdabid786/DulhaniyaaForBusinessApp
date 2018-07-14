package com.dulhaniyaa.dulhaniyaaforbusinessapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.R;
import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

public class Splash extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    SharedPreferences spLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
//        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_splash);


        spLogin = getSharedPreferences("LOGINSP", MODE_PRIVATE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (spLogin.getBoolean("LOGIN_CHECK", false) == true) {
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        }, 5000);

        imageView = findViewById(R.id.splash);
        textView = findViewById(R.id.tv_motive);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);

        textView.startAnimation(animation);
    }
}
