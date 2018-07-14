package com.dulhaniyaa.dulhaniyaaforbusinessapp.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.adapter.ChatAdapter;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.R;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.databinding.SChatBinding;

public class Chat extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private SChatBinding mBinding;
    private TextView mToolbarTv;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ChatAdapter mAdapter;
    private ImageView mBackIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.s_chat);

        mToolbar = (Toolbar) findViewById(R.id.back_toolbar);
        setSupportActionBar(mToolbar);

        init();
        setData();
    }

    private void setData() {
        mToolbarTv.setText("ABC Resturant");
        mBackIv.setOnClickListener(this);
    }

    private void init() {
        mToolbarTv = (TextView) findViewById(R.id.back_toolbar_tv);
        mBackIv = (ImageView) findViewById(R.id.back_toolbar_iv);
        mRecyclerView = (RecyclerView) findViewById(R.id.chat_rv);
        mLayoutManager = new LinearLayoutManager(Chat.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ChatAdapter(Chat.this);
        mRecyclerView.setAdapter(mAdapter);

        /*mBinding.chatEt.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                v.getParent().requestDisallowInterceptTouchEvent(true);
                switch (event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_UP:
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        return true;
                }
                return false;
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_toolbar_iv:
                super.onBackPressed();
//                overridePendingTransition(R.anim.left_to_right, R.anim.exit);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        overridePendingTransition(R.anim.left_to_right, R.anim.exit);
    }
}
