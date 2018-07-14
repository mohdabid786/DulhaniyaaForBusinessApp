package com.dulhaniyaa.dulhaniyaaforbusinessapp.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.R;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.bean.CommonResponse;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.retrofit.ApiClient;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.retrofit.ApiInterface;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.retrofit.MyDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener{

    TextView tv_cancel;
    Button send_button;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this,R.layout.activity_forgot_password);

        tv_cancel = findViewById(R.id.tv_cancel);
        send_button = findViewById(R.id.send_button);
        username = findViewById(R.id.enter_email);

        tv_cancel.setOnClickListener(this);
        send_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.tv_cancel:
                onBackPressed();
                break;

            case R.id.send_button:
                if (username.getText().toString().equals(""))
                {
                    Toast.makeText(this,"Please enter email id",Toast.LENGTH_LONG).show();
                }else
                    callForgotPasswordApi();
                break;

        }

    }
    private void callForgotPasswordApi()
    {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface=  retrofit.create(ApiInterface.class);
        Call<CommonResponse> call=apiInterface.getForgotResult(username.getText().toString());

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(ForgotPassword.this).hideDialog();
                if (response.isSuccessful())
                {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        startActivity(new Intent(ForgotPassword.this,ResetPassword.class));
                    }else
                    {
                        Toast.makeText(ForgotPassword.this,response.body().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(ForgotPassword.this).hideDialog();
            }
        });
    }
}
