package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

//Sini Main Menu fana
public class BeverageDetailActivity extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {
    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    public CardView card1,card2,card3,card4,card5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage_detail);

        /*---buttons/cardview---*/
        card1 = (CardView) findViewById(R.id.c1);
        card2 = (CardView) findViewById(R.id.c2);
        card3 = (CardView) findViewById(R.id.c3);
        card4 = (CardView) findViewById(R.id.c4);
        card5 = (CardView) findViewById(R.id.c5);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);

        /*---hooks---*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        /*---tool bar---*/
        setSupportActionBar(toolbar);

        /*---nav drawer menu---*/
        //Hide or show items
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);

    }
    /*---to avoid closing the application on Back pressed---*/
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;
        switch (menuItem.getItemId()){
            case R.id.nav_home:
                break;
                case R.id.nav_booking:
                intent = new Intent(BeverageDetailActivity.this, BookingActivity.class);
                startActivity(intent);
                break;
                case R.id.nav_venue:
                intent = new Intent(BeverageDetailActivity.this,Venue.class);
                startActivity(intent);
                break;
                case R.id.nav_ads:
                intent = new Intent(BeverageDetailActivity.this,Advertisement.class);
                startActivity(intent);
                break;
                case R.id.nav_gc:
                intent = new Intent(BeverageDetailActivity.this,GuestCrew.class);
                startActivity(intent);
                break;
                case R.id.nav_dashboard:
                intent = new Intent(BeverageDetailActivity.this,Dashboard.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()){
            case R.id.c1:
                i = new Intent(this, BookingActivity.class);
                startActivity(i);
                break;
            case R.id.c2:
                i = new Intent(this,GuestCrew.class);
                startActivity(i);
                break;
            case R.id.c3:
                i = new Intent(this,Advertisement.class);
                startActivity(i);
                break;
            case R.id.c4:
                i = new Intent(this,Venue.class);
                startActivity(i);
                break;
            case R.id.c5:
                i = new Intent(this,Dashboard.class);
                startActivity(i);
                break;
        }

    }
}