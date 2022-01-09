package com.example.loginregister.CMainMenu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.loginregister.Dashboard;
import com.example.loginregister.EGuestCrew.GuestCrew;
import com.example.loginregister.ALoginRegister.Login;
import com.example.loginregister.FVenue.VenueActivity;
import com.example.loginregister.GAds.AdsActivity;
import com.example.loginregister.R;
import com.example.loginregister.DBooking.BookingActivity;
import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

//Main Menu fana
public class BeverageDetailActivity extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {
    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    //cerita countdown

    long daycounter;
    Calendar calendar;
    Calendar currentdate;

    //

    //Tukar Image Banner
    ImageView mImageView;
    ImageButton mImageButton;
    int SELECT_PICTURE = 200;


    TextView tv_eventName, tv_eventDate, tv_eventTime,tv_countdown;

    public CardView card1,card2,card3,card4,card5;
    String EventName, EventDate, EventTime, EventDateTime;
    int id;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage_detail);

        tv_eventName = findViewById(R.id.tv_eventName);
        tv_eventDate = findViewById(R.id.tv_eventDate);
        tv_eventTime = findViewById(R.id.tv_eventTime);
        tv_countdown = findViewById(R.id.tv_countdown);

        //VIEWS (tukar image banner)
        mImageView = findViewById(R.id.imageView);
        mImageButton = findViewById(R.id.imageButton3);
        //handle button click
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();
            }
        });

//        tv_eventName.setText(extra.getString("event_name"));
//        tv_eventDate.setText(extra.getString("event_date"));
//        tv_eventTime.setText(extra.getString("event_time"));

        if(savedInstanceState==null) {
            Bundle extra = getIntent().getExtras();
            id = extra.getInt("id");
            EventName = extra.getString("event_name");
            EventDate = extra.getString("event_date");
            EventTime = extra.getString("event_time");

            EventDateTime = EventDate+" "+EventTime;
        }else{
            id=(int)savedInstanceState.getSerializable("id");
            EventName=(String)savedInstanceState.getSerializable("event_name");
            EventDate=(String)savedInstanceState.getSerializable("event_date");
            EventTime=(String)savedInstanceState.getSerializable("event_time");
        }
        tv_eventName.setText(EventName);
        tv_eventDate.setText(EventDate);
        tv_eventTime.setText(EventTime);

//        Toast.makeText(getApplicationContext(), ""+EventName, Toast.LENGTH_LONG).show();
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
//        menu.findItem(R.id.nav_logout).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);


        // calendar countdown ---------------------------------------------------------------------------

        calendar = Calendar.getInstance(Locale.getDefault());
        currentdate = Calendar.getInstance();
        long time= System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        LocalDateTime localDate = LocalDateTime.parse(EventDateTime, formatter);
        long timeInMilliseconds = localDate.atOffset(ZoneOffset.UTC).toInstant().toEpochMilli();

        Date mDate = new Date();
//        try {
//            mDate = sdf.parse(EventDateTime);
//            long timeInMilliseconds = mDate.getTime();
//            System.out.println("Date in milli :: " + timeInMilliseconds);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }



            Long currentdateInMili= currentdate.getTimeInMillis();
            daycounter = (timeInMilliseconds-currentdateInMili);

            final long dy = TimeUnit.MILLISECONDS.toDays(daycounter);
            final long hr = TimeUnit.MILLISECONDS.toHours(daycounter)
                    - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(daycounter));
            final long min = TimeUnit.MILLISECONDS.toMinutes(daycounter)
                    - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(daycounter));
            final long sec = TimeUnit.MILLISECONDS.toSeconds(daycounter)
                    - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(daycounter));



            tv_countdown.setText(String.format("%d Days %d Hours %d Minutes %d Seconds", dy, hr, min, sec));
//            tv_countdown.setText(sdf.format(mDate));
//            tv_countdown.setText(EventDateTime);




//            Toast.makeText(getApplicationContext(), "Anwar", Toast.LENGTH_LONG).show();


//        new CountDownTimer(30000, 1000) {
//
//            public void onTick(long millisUntilFinished) {
////                tv_countdown.setText("seconds remaining: " + millisUntilFinished / 1000);
////                here you can have your logic to set text to edittext
//            }
//
//            public void onFinish() {
//                tv_countdown.setText("done!");
//            }
//
//        }.start();

// ------------------------------------------------------------------------------------------------------------------


    }

    // this function is triggered when
    // the Select Image Button is clicked
    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    mImageView.setImageURI(selectedImageUri);
                }
            }
        }
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
                intent.putExtra("id", id);
                startActivity(intent);
                break;
                case R.id.nav_venue:
                intent = new Intent(BeverageDetailActivity.this, VenueActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                break;
                case R.id.nav_ads:
                intent = new Intent(BeverageDetailActivity.this, AdsActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                break;
                case R.id.nav_gc:
                intent = new Intent(BeverageDetailActivity.this, GuestCrew.class);
                intent.putExtra("id", id);
                startActivity(intent);
                break;
                case R.id.nav_dashboard:
                intent = new Intent(BeverageDetailActivity.this, Dashboard.class);
                startActivity(intent);
                break;
                case R.id.nav_log_out:
                intent = new Intent(BeverageDetailActivity.this, Login.class);
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
                i.putExtra("id", id);
                startActivity(i);
                break;
            case R.id.c2:
                i = new Intent(this,GuestCrew.class);
                i.putExtra("id", id);
                startActivity(i);
                break;
            case R.id.c3:
                i = new Intent(this,AdsActivity.class);
                i.putExtra("id", id);
                startActivity(i);
                break;
            case R.id.c4:
                i = new Intent(this, VenueActivity.class);
                i.putExtra("id", id);
                startActivity(i);
                break;
            case R.id.c5:
                i = new Intent(this,Dashboard.class);
                startActivity(i);
                break;
        }

    }
}