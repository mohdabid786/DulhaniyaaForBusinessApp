package com.dulhaniyaa.dulhaniyaaforbusinessapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class OTP extends AppCompatActivity {

    Button btn_verify;
    String verifactionCode,business_name, username, password, phone, category, city;
    EditText edit1,edit2,edit3,edit4;
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        btn_verify=(Button)findViewById(R.id.btn_verify);
        edit1=(EditText)findViewById(R.id.edit1);
        edit2=(EditText)findViewById(R.id.edit2);
        edit3=(EditText)findViewById(R.id.edit3);
        edit4=(EditText)findViewById(R.id.edit4);

        try {
            verifactionCode = getIntent().getStringExtra("verification");
            business_name=getIntent().getStringExtra("name");
            username=getIntent().getStringExtra("email");
            phone=getIntent().getStringExtra("phone");
            category=getIntent().getStringExtra("category");
            city=getIntent().getStringExtra("city");
            password=getIntent().getStringExtra("password");
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code=edit1.getText().toString()+edit2.getText().toString()+edit3.getText().toString()+edit4.getText().toString();
                if (code.equals(""))
                {
                    Toast.makeText(OTP.this,"please enter otp",Toast.LENGTH_LONG).show();
                }else {
                    if (verifactionCode.equals(code)) {
                        callRegisteredApi();
                    }
                }

            }
        });

        ImageView iv_back  =( ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        edit1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(edit1.getText().toString().length()==1)     //size as per your requirement
                {
                    edit2.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });
        edit2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(edit2.getText().toString().length()==1)     //size as per your requirement
                {
                    edit3.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });
        edit3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(edit3.getText().toString().length()==1)     //size as per your requirement
                {
                    edit4.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });
    }

    private void callRegisteredApi()
    {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface=  retrofit.create(ApiInterface.class);
        Call<CommonResponse> call=apiInterface.getSingupResult(business_name,username,phone,password,category,city,
                "android", SharedPreferenceWriter.getInstance(this).getString(SharedPreferenceKey.device_token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(OTP.this).hideDialog();
                if (response.isSuccessful())
                {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        SharedPreferenceWriter.getInstance(OTP.this).writeStringValue(SharedPreferenceKey.token, response.body().getSignup().getToken());
                        SharedPreferenceWriter.getInstance(OTP.this).writeBooleanValue(SharedPreferenceKey.currentLogin,true);
                        Intent intent = new Intent(OTP.this, Home.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(OTP.this).hideDialog();
            }
        });

    }
}
