package com.example.loginregister.EGuestCrew;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.loginregister.EGuestCrew.tab.SectionsPagerAdapter;
import com.example.loginregister.databinding.ActivityGuestCrewBinding;

public class GuestCrew extends AppCompatActivity {

    int id;
    private ActivityGuestCrewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState==null) {
            Bundle extra = getIntent().getExtras();
            id = extra.getInt("id");
        }else{
            id=(int)savedInstanceState.getSerializable("id");
        }

        binding = ActivityGuestCrewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

    }
}