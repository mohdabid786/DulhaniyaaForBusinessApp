package com.dulhaniyaa.dulhaniyaaforbusinessapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.R;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.bean.CommonResponse;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.database.SharedPreferenceWriter;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.retrofit.ApiClient;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.retrofit.ApiInterface;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.retrofit.MyDialog;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.util.SharedPreferenceKey;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    TextView forget_password;
    CheckBox checkBox;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        forget_password = findViewById(R.id.forgot_password);
        checkBox = findViewById(R.id.checkbox);
        login = findViewById(R.id.login);

        username.setOnClickListener(this);
        password.setOnClickListener(this);
        forget_password.setOnClickListener(this);
        checkBox.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.checkbox:
                Intent intent = new Intent(Login.this, Home.class);
                startActivity(intent);
                break;
            case R.id.forgot_password:
                Intent intent1 = new Intent(Login.this, Home.class);
                startActivity(intent1);
                break;
            case R.id.login:
                checkLogin();
//                callLoginApi();
                break;

        }
    }

    private void callLoginApi() {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getLoginResult(username.getText().toString(), password.getText().toString(),
                "android", SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.device_token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(Login.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.token, response.body().getLogin().getToken());
                        SharedPreferenceWriter.getInstance(Login.this).writeBooleanValue(SharedPreferenceKey.currentLogin, true);
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.NOTIFICATION_STATUS, response.body().getLogin().getStatus());
                        SharedPreferenceWriter.getInstance(Login.this).writeStringValue(SharedPreferenceKey.Email, response.body().getLogin().getEmail());
                        Intent intent = new Intent(Login.this, Home.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Login.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(Login.this).hideDialog();
            }
        });
    }

    private void checkLogin() {
        boolean flag = true;
        if (username.getText().toString().equals("")) {
            Toast.makeText(Login.this, "Please enter email id", Toast.LENGTH_LONG).show();
            flag = false;
        } else if (password.getText().toString().equals("")) {
            Toast.makeText(Login.this, "Please enter password", Toast.LENGTH_LONG).show();
            flag = false;
        } else {
            callLoginApi();
        }
    }
}
