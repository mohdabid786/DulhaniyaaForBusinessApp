package com.dulhaniyaa.dulhaniyaaforbusinessapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button login, signup;
    TextView user_app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);
        user_app = findViewById(R.id.user_app);

        login.setOnClickListener(this);
        signup.setOnClickListener(this);
        user_app.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.login:
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                break;
            case R.id.signup:
                Intent intent1 = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent1);
                break;
            case R.id.user_app:
                Intent intent2 = new Intent(MainActivity.this, Home.class);
                startActivity(intent2);
//                intent5.putExtra("url", "https://www.dulhaniyaa.com/front/privacy");
//                intent5.putExtra("toolText", "Privacy Policy");
//                startActivity(intent5);
                break;

        }
    }
}
