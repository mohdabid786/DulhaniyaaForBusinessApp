package com.dulhaniyaa.dulhaniyaaforbusinessapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.fragment.Leads;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.fragment.Portfolio;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.fragment.Review;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.fragment.Statistics;

public class HomeAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public HomeAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Leads tab1 = new Leads();
                return tab1;
            case 1:
                Portfolio tab2 = new Portfolio();
                return tab2;
            case 2:
                Statistics tab3 = new Statistics();
                return tab3;
            case 3:
                Review tab4 = new Review();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }


}

//        extends FragmentPagerAdapter {
//    public HomeAdapter(FragmentManager fm) {
//        super(fm);
//    }
//
//    @Override
//    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                return new Leads();
//            case 1:
//                return new Portfolio();
//            case 2:
//                return new Statistics();
//            case 3:
//                return new Review();
//        }
//        return null;
//    }
//
//    @Override
//    public int getCount() {
//        return 4;
//    }

