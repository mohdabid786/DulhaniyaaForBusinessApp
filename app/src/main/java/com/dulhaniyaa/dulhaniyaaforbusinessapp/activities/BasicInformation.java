package com.dulhaniyaa.dulhaniyaaforbusinessapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.R;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.adapter.GetAllCategoryAdapter;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.adapter.GetAllStateAdapter;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.adapter.HomeAdapter;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.adapter.WorkingDaysAdapter;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.bean.CommonResponse;
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

public class BasicInformation extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private ArrayList<String> mWorkdaysList;
    private String workdaysList;
    private Spinner mWorkdaysSpinner;
    private String mWorkdaysSpinnerItem;

    private ArrayList<String> mPaymentmodeList;
    private String paymentmodeList;
    private Spinner mPaymentmodeSpinner;
    private String mPaymentmodeSpinnerItem;


    TextView business_name;
    TextView email;
    TextView city;
    TextView vendor_category;
    EditText contact_name;
    EditText contact_email;
    EditText phone_number;
    ImageView plus_icon;
    ImageView phone_icon;
    EditText sub_id;
    EditText vb_budget;
    EditText vb_estd;
    EditText vb_info;
    EditText vb_address;
    EditText vb_pincode;
    EditText vb_landmark;
    Spinner pay_id;
    Spinner work_id;
    EditText vb_media;
    EditText vb_award;
    EditText vb_pastexp;
    EditText vb_online;
    EditText vs_facebook_profile;
    EditText vs_instagram_profile;
    EditText vs_website;
    EditText vs_youtube_channel;
    EditText vs_vimeo;
    EditText vs_pinterest;
    EditText vs_twitter;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_information);


        business_name = findViewById(R.id.basic_business_name);
        email.findViewById(R.id.basic_email);
        city.findViewById(R.id.city);
        vendor_category.findViewById(R.id.vendor_category);
        contact_name.findViewById(R.id.basic_contact_name);
        contact_email.findViewById(R.id.contact_email);
        phone_number.findViewById(R.id.phone_number);
        plus_icon.findViewById(R.id.plus_icon);
        phone_icon.findViewById(R.id.phone_icon);
        sub_id.findViewById(R.id);
        vb_budget.findViewById(R.id.vb_budget);
        vb_estd.findViewById(R.id.vb_estd);
        vb_info.findViewById(R.id.vb_info);
        vb_address.findViewById(R.id.vb_address);
        vb_pincode.findViewById(R.id.vb_pincode);
        vb_landmark.findViewById(R.id.vb_landmark);
        pay_id.findViewById(R.id.pay_id);
        work_id.findViewById(R.id.work_id);
        vb_media.findViewById(R.id.vb_media);
        vb_award.findViewById(R.id.vb_award);
        vb_pastexp.findViewById(R.id.vb_pastexp);
        vb_online.findViewById(R.id.vb_online);
        vs_facebook_profile.findViewById(R.id.facebook_profile);
        vs_instagram_profile.findViewById(R.id.instagram_profile);
        vs_website.findViewById(R.id.website);
        vs_youtube_channel.findViewById(R.id.youtube_channel);
        vs_vimeo.findViewById(R.id.vs_vimeo);
        vs_pinterest.findViewById(R.id.vs_pinterest);
        vs_twitter.findViewById(R.id.vs_twitter);
        save.findViewById(R.id.save);


        business_name.setOnClickListener(this);
        email.setOnClickListener(this);
        city.setOnClickListener(this);
        vendor_category.setOnClickListener(this);
        contact_name.setOnClickListener(this);
        contact_email.setOnClickListener(this);
        phone_number.setOnClickListener(this);
        plus_icon.setOnClickListener(this);
        phone_icon.setOnClickListener(this);
        sub_id.setOnClickListener(this);
        vb_budget.setOnClickListener(this);
        vb_estd.setOnClickListener(this);
        vb_info.setOnClickListener(this);
        vb_address.setOnClickListener(this);
        vb_pincode.setOnClickListener(this);
        vb_landmark.setOnClickListener(this);
        pay_id.setOnClickListener(this);
        work_id.setOnClickListener(this);
        vb_media.setOnClickListener(this);
        vb_award.setOnClickListener(this);
        vb_pastexp.setOnClickListener(this);
        vb_online.setOnClickListener(this);
        vs_facebook_profile.setOnClickListener(this);
        vs_instagram_profile.setOnClickListener(this);
        vs_website.setOnClickListener(this);
        vs_youtube_channel.setOnClickListener(this);
        vs_vimeo.setOnClickListener(this);
        vs_pinterest.setOnClickListener(this);
        vs_twitter.setOnClickListener(this);
        save.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.basic_business_name:
                break;
            case R.id.basic_email:
                break;
            case R.id.city:
                break;
            case R.id.basic_contact_name:
                break;
            case R.id.contact_email:
                break;
            case R.id.contact_phone:
                break;
            case R.id.sub_id:
                break;
            case R.id.vb_budget:
                break;
            case R.id.vb_estd:
                break;
            case R.id.vb_info:
                break;
            case R.id.vb_address:
                break;
            case R.id.vb_pincode:
                break;
            case R.id.vb_landmark:
                break;
            case R.id.pay_id:
                break;
            case R.id.work_id:
                break;
            case R.id.vb:vb_media:
                break;
            case R.id.vb_awards:
                break;
            case R.id.vb_pastexp:
                break;
            case R.id.vb_online:
                break;
            case R.id.vs_facebook:
                break;
            case R.id.vs_instagram:
                break;
            case R.id.vs_website:
                break;
            case R.id.vs_:vs_youtube_channel:
                break;
            case R.id.vs_vimeo:
                break;
            case R.id.vs_pinterest:
                break;
            case R.id.vs_twitter:
                break;
            case R.id.save:
                break;

        }
    }


    private void callVendorProfileApi() {
        MyDialog.getInstance(BasicInformation.this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getVendorProfileResult(SharedPreferenceWriter.getInstance(BasicInformation.this)
                .getString(SharedPreferenceKey.token));

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(BasicInformation.this).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {


                    } else {
                        Toast.makeText(BasicInformation.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(BasicInformation.this).hideDialog();
            }
        });
    }

    private void callWorkdaysApi() {

        MyDialog.getInstance(BasicInformation.this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getWorkdayResult();

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(BasicInformation.this).hideDialog();

                if (response.body().getStatus().equals("SUCCESS")) {
                    if (response.isSuccessful()) {
                        for (int i = 0; i < response.body().getGetAllState().size(); i++) {

                            workdaysList = response.body().getWorkdays().get(i).getDayName();
                            mWorkdaysList.add(workdaysList);

                        }

                        WorkingDaysAdapter setWorkdayAdapter = new WorkingDaysAdapter(BasicInformation.this,
                                R.layout.simple_spinner_item, mWorkdaysList);
                        mWorkdaysSpinner.setAdapter(setWorkdayAdapter);

                    } else {
                        if (response.body().getMessage().equals("Invalid User.")) {

                            Intent intent = new Intent(BasicInformation.this, Login.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                    Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                    Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(BasicInformation.this).hideDialog();
            }

        });
    }

    private void callPaymentModeApi() {

        MyDialog.getInstance(BasicInformation.this).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<CommonResponse> call = apiInterface.getPaymentmodeResult();

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(BasicInformation.this).hideDialog();

                if (response.body().getStatus().equals("SUCCESS")) {
                    if (response.isSuccessful()) {
                        for (int i = 0; i < response.body().getPaymentmode().size(); i++) {

                            paymentmodeList = response.body().getPaymentmode().get(i).getPayName();
                            mPaymentmodeList.add(paymentmodeList);

                        }

                        WorkingDaysAdapter setWorkdayAdapter = new WorkingDaysAdapter(BasicInformation.this,
                                R.layout.simple_spinner_item, mPaymentmodeList);
                        mPaymentmodeSpinner.setAdapter(setWorkdayAdapter);

                    } else {
                        if (response.body().getMessage().equals("Invalid User.")) {

                            Intent intent = new Intent(BasicInformation.this, Login.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                    Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                    Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(BasicInformation.this).hideDialog();
            }

        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        getWorkdaysSpinnerItem(parent.getItemAtPosition(position) + "");
        getPaymentModeSpinnerItem(parent.getItemAtPosition(position) + "");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void getWorkdaysSpinnerItem(String workdaysspinnerItems) {
        mWorkdaysSpinnerItem = workdaysspinnerItems;

    }

    private void getPaymentModeSpinnerItem(String paymentmodeSpinnerItems) {
        mPaymentmodeSpinnerItem = paymentmodeSpinnerItems;

    }
}
