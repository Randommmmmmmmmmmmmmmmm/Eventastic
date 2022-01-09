package com.example.loginregister.FAdvertisement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.loginregister.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AdvertisementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisement);

        FloatingActionButton fbtn_createAds;

        fbtn_createAds = findViewById(R.id.fbtn_createAds);

        fbtn_createAds.setOnClickListener(view -> {

            Intent intent = new Intent(getApplicationContext(), AdvertisementAddDetail.class);
            startActivity(intent);
        });
    }
}