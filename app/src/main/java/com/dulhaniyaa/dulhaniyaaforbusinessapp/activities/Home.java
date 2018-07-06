package com.dulhaniyaa.dulhaniyaaforbusinessapp.activities;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.R;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.util.BusinessApplication;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ComponentName context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_basic_info) {
            Intent intent = new Intent(Home.this, BasicInformation.class);
            startActivity(intent);

        } else if (id == R.id.nav_business_info) {
            Intent intent = new Intent(Home.this, BusinessInformation.class);
            startActivity(intent);

        } else if (id == R.id.nav_membership) {
            Intent intent = new Intent(Home.this, MembershipPackages.class);
            startActivity(intent);

        } else if (id == R.id.nav_invite_review) {
//            Intent intent = new Intent(Home.this, BasicInformation.class);
//            startActivity(intent);

        } else if (id == R.id.nav_updates) {
            Intent intent = new Intent(Home.this, DulhaiyaaUpdates.class);
            startActivity(intent);

        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(Home.this, Setting.class);
            startActivity(intent);

        } else if (id == R.id.nav_contact_support) {

            Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            String aEmailList[] = {"vendors@dulhaniyaa.com"};
//            String aEmailCCList[] = { "info@dulhaniyaa.com" };
//            String aEmailBCCList[] = {"pal@duhaniyaa.com", "ag@dulhaniyaa.com"};
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
//            emailIntent.putExtra(android.content.Intent.EXTRA_CC, aEmailCCList);
//            emailIntent.putExtra(android.content.Intent.EXTRA_BCC, aEmailBCCList);
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Support for Dulhaniyaa for Business" + "|" + "Pal De ");
            emailIntent.setType("text/plain");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Welcome to Dulhaniyaa");
            startActivity(emailIntent);
            //startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();

        } else if (id == R.id.nav_rate_on_playstore) {

            Uri uri = Uri.parse("market://details?id=" + context.getPackageName());
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            // To count with Play market backstack, After pressing back button,
            // to taken back to our application, we need to add following flags to intent.
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
            }

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
