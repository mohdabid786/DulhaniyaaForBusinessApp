package com.dulhaniyaa.dulhaniyaaforbusinessapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.R;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.adapter.GetAllCategoryAdapter;
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

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private Spinner category, city;
    private GetAllCategoryAdapter getAllCategoryAdapter;
    ArrayList<GetAllCateogry> getAllCategoryArrayList;
    ArrayList<GetAllCateogry> getAllCategoryArrayListClone;
    ArrayList<GetAllCateogry> arrayList;
    GetAllCategoryInterface getAllCategoryInterface;
    ArrayList<GetAllCateogry> getAllCategoryList;

    private EditText business_name, username, password, phone;
    private Button signup;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

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
        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,getAllCategoryArrayList);
        aa.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        category.setAdapter(aa);
        city.setOnClickListener(this);
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
                        SharedPreferenceWriter.getInstance(SignUp.this).writeStringValue(SharedPreferenceKey.token,
                                response.body().getSignup().getToken());
                        Intent intent = new Intent(SignUp.this, OTP.class);
                        intent.putExtra("verification", response.body().getVerificationCode());
                        intent.putExtra("name", business_name.getText().toString());
                        intent.putExtra("email", username.getText().toString());
                        intent.putExtra("phone", phone.getText().toString());
                        intent.putExtra("password", password.getText().toString());
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
        Call<CommonResponse> call = apiInterface.getGetAllCateogryResult(SharedPreferenceWriter.getInstance(SignUp.this)
                .getString(SharedPreferenceKey.token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(SignUp.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        //here,we get all the response of Home api.using getter method,like getHome(),we got the response.here response is comeing in array form,so to store this we take arraylist type variable which is globally declared above
                        getAllCategoryArrayList = (ArrayList<GetAllCateogry>) response.body().getGetAllCateogry();

                        getAllCategoryArrayListClone = new ArrayList<GetAllCateogry>();
                        arrayList = new ArrayList<>();
                        getAllCategoryArrayListClone.addAll(getAllCategoryArrayList);
                        arrayList.addAll(getAllCategoryArrayListClone);

                        //
                        getAllCategoryInterface.getGetAllCategoryList(arrayList);

                        //here response is comeing in List form,so to store homeResponseArrayList,we declare homeResponseArrayList as blank list like  ArrayList<HomeResponse> homeResponseArrayList;
                        //to call HomeAdapter on Home Fragment using constructor made in HomeAdapter class
                        getAllCategoryAdapter = new GetAllCategoryAdapter(SignUp.this, getAllCategoryArrayList, SignUp.this);
                        // Attach the adapter to a recyclerview
                        category.setAdapter((SpinnerAdapter) getAllCategoryAdapter);//on recyclerview we set the adapter.

                    } else {
                        Toast.makeText(SignUp.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
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
        } else if (category.equals("")) {
            Toast.makeText(SignUp.this, "Please select category", Toast.LENGTH_LONG).show();
            flag = false;
        } else if (city.equals("")) {
            Toast.makeText(SignUp.this, "Please select city", Toast.LENGTH_LONG).show();
            flag = false;
        } else {
            callchkUserApi();
        }

    }
    public interface GetAllCategoryInterface {
        public void getGetAllCategoryList(ArrayList<GetAllCateogry> homeResponseArrayListsss);
    }
}

