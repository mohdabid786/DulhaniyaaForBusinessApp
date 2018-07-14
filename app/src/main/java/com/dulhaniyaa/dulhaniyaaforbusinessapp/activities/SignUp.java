package com.dulhaniyaa.dulhaniyaaforbusinessapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.R;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.adapter.GetAllCategoryAdapter;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.adapter.GetAllStateAdapter;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.bean.CommonResponse;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.bean.GetAllCateogry;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.database.SharedPreferenceWriter;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.retrofit.ApiClient;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.retrofit.ApiInterface;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.retrofit.MyDialog;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.util.SharedPreferenceKey;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SignUp extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

//    private EditText category, city;

    private ArrayList<String> mCategoryList;
    private String catNameList;
    private String catIdList;
    private ArrayList<String> mCityList;
    private String nameList;
    private String mSpinnerStateItem, mSpinnerCategoryItem;

    private Spinner category, city;

    private EditText business_name, username, password, phone;
    private Button signup;
    SharedPreferences spLogin;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        spLogin = getSharedPreferences("LOGINSP", MODE_PRIVATE);

        business_name = findViewById(R.id.business_name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.enter_phone_number);
        category = findViewById(R.id.sp_category);
        city = findViewById(R.id.sp_city);
        signup = findViewById(R.id.btn_signup);


        business_name.setOnClickListener(this);
        username.setOnClickListener(this);
        password.setOnClickListener(this);
        phone.setOnClickListener(this);
        category.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        city.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_signup:
                checkSignup();
                break;
            case R.id.category:
                callCategoryApi();
            case R.id.city:
                callCityApi();

        }
    }


    private void callVerificationCodeApi() {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getverificationCodeResult(phone.getText().toString());

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(SignUp.this).hideDialog();
                if (response.isSuccessful()) {
                    Toast.makeText(SignUp.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    if (response.body().getStatus().equals("SUCCESS")) {
//                        SharedPreferenceWriter.getInstance(SignUp.this).writeStringValue(SharedPreferenceKey.token,
//                                response.body().getVendorSignup().getToken());
                        Intent intent = new Intent(SignUp.this, OTP.class);
                        intent.putExtra("verification", response.body().getVerificationCode());
                        intent.putExtra("business_name", business_name.getText().toString());
                        intent.putExtra("email", username.getText().toString());
                        intent.putExtra("password", password.getText().toString());
                        intent.putExtra("phone", phone.getText().toString());
                        intent.putExtra("category", category.getOnItemSelectedListener().toString());
                        intent.putExtra("city", city.getOnItemSelectedListener().toString());
                        startActivity(intent);
//                        Toast.makeText(SignUp.this,response.body().getVerificationCode(),Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(SignUp.this).hideDialog();
            }
        });
    }

    private void callchkUserApi() {
        MyDialog.getInstance(this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getcheckVendorResult(phone.getText().toString(), username.getText().toString());

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(SignUp.this).hideDialog();
                if (response.isSuccessful()) {
                    Toast.makeText(SignUp.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    if (response.body().getStatus().equals("SUCCESS")) {
                        callVerificationCodeApi();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(SignUp.this).hideDialog();
            }
        });
    }

    private void callCategoryApi() {
        MyDialog.getInstance(SignUp.this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getGetAllCateogryResult();

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(SignUp.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        if (response.isSuccessful()) {
                            for (int i = 0; i < response.body().getGetAllCateogry().size(); i++) {
                                catNameList = response.body().getGetAllCateogry().get(i).getCatName();
                                catIdList = response.body().getGetAllCateogry().get(i).getCatId();
                                mCategoryList.add(catNameList);

                            }

                            GetAllCategoryAdapter setCityAdapter = new GetAllCategoryAdapter(SignUp.this,
                                    R.layout.simple_spinner_item, mCategoryList);
                            category.setAdapter(setCityAdapter);
                        } else {
                            if (response.body().getMessage().equals("Invalid User.")) {
                                Intent intent = new Intent(SignUp.this, Login.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                        Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(SignUp.this).hideDialog();
            }

        });
    }


    private void callCityApi() {

        MyDialog.getInstance(SignUp.this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getGetAllStateResult();

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(SignUp.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        if (response.isSuccessful()) {
                            for (int i = 0; i < response.body().getGetAllState().size(); i++) {

                                nameList = response.body().getGetAllState().get(i).getStateName();
                                mCityList.add(nameList);

                            }

                            GetAllStateAdapter setCityAdapter = new GetAllStateAdapter(SignUp.this,
                                    R.layout.simple_spinner_item, mCityList);
                            city.setAdapter(setCityAdapter);

                        } else {
                            if (response.body().getMessage().equals("Invalid User.")) {

                                Intent intent = new Intent(SignUp.this, Login.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                        Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                        Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        }
                    }
                }
            }


            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(SignUp.this).hideDialog();
            }

        });
    }


    void checkSignup() {
        boolean flag = true;
        if (business_name.getText().toString().equals("")) {
            Toast.makeText(SignUp.this, "Please enter your business name", Toast.LENGTH_LONG).show();
            flag = false;
        } else if (username.getText().toString().equals("")) {
            Toast.makeText(SignUp.this, "Please enter e-mail address", Toast.LENGTH_LONG).show();
            flag = false;
        } else if (password.getText().toString().equals("")) {
            Toast.makeText(SignUp.this, "Please enter password", Toast.LENGTH_LONG).show();
            flag = false;
        } else if (phone.getText().toString().equals("")) {
            Toast.makeText(SignUp.this, "Please enter phone number", Toast.LENGTH_LONG).show();
            flag = false;
        } else if (mSpinnerCategoryItem.equals("")) {
            Toast.makeText(SignUp.this, "Please select category", Toast.LENGTH_LONG).show();
            flag = false;
        } else if (mSpinnerStateItem.equals("")) {
            Toast.makeText(SignUp.this, "Please select city", Toast.LENGTH_LONG).show();
            flag = false;
        } else {
            callchkUserApi();
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        getCategorySpinnerItem(parent.getItemAtPosition(position) + "");
        getCitySpinnerItem(parent.getItemAtPosition(position)+"");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void getCategorySpinnerItem(String spinnerItems) {
        mSpinnerCategoryItem = spinnerItems;
    }
    private void getCitySpinnerItem(String spinnerItems) {
        mSpinnerStateItem = spinnerItems;
    }
}

