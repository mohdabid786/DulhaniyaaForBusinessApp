package com.dulhaniyaa.dulhaniyaaforbusinessapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
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

public class Setting extends AppCompatActivity implements View.OnClickListener {

    ImageView back;
    ImageView profile_pic;
    TextView change_password, sign_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        back = findViewById(R.id.back_button);
        profile_pic = findViewById(R.id.cover_banner);
        change_password = findViewById(R.id.change_password);
        sign_out = findViewById(R.id.sign_out);

        back.setOnClickListener(this);
        profile_pic.setOnClickListener(this);
        change_password.setOnClickListener(this);
        sign_out.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.back_button:
                onBackPressed();
                break;
            case R.id.cover_banner:
                break;
            case R.id.change_password:
                Intent intent = new Intent(Setting.this, ChangePassword.class);
                startActivity(intent);
                break;
            case R.id.sign_out:
                callLogoutApi();
                break;


        }

    }


    private void callLogoutApi() {
        MyDialog.getInstance(Setting.this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getLogoutResult(SharedPreferenceWriter.getInstance(Setting.this)
                .getString(SharedPreferenceKey.token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(Setting.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Setting.this.finish();
                        SharedPreferenceWriter.getInstance(Setting.this).writeBooleanValue(SharedPreferenceKey.currentLogin, false);
                        Intent intent = new Intent(Setting.this, Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                    Toast.makeText(Setting.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(Setting.this).hideDialog();
            }
        });
    }
}
