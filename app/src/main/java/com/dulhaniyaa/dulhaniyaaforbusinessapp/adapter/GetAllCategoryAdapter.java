package com.dulhaniyaa.dulhaniyaaforbusinessapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GetAllCategoryAdapter extends BaseAdapter implements SpinnerAdapter {
    private final ArrayList<String> mCategoryList;
    private Context context;

    public GetAllCategoryAdapter(Context context, int simple_spinner_item, ArrayList<String> mCategoryList) {
        this.context=context;
        this.mCategoryList=mCategoryList;
    }


    @Override
    public int getCount() {
        return mCategoryList.size();
    }

    @Override
    public Object getItem(int i) {
        return mCategoryList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView txt = new TextView(context);
        txt.setGravity(Gravity.START);
        txt.setTextSize(17);
        txt.setPadding(80,0,0,0);
        txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        txt.setText(mCategoryList.get(i));
        txt.setTextColor(Color.parseColor("#000000"));
        return  txt;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView txt = new TextView(context);
        txt.setPadding(15, 8, 12, 8);
        txt.setTextSize(14);
        txt.setGravity(Gravity.START);
        txt.setText(mCategoryList.get(position));
        txt.setTextColor(Color.parseColor("#000000"));
        return  txt;    }

}
