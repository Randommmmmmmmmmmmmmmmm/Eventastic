package com.example.loginregister.EGuestCrew;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.loginregister.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

public class GuestCrewFragment1 extends Fragment {

    FloatingActionButton fbtn_createGuest;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.guestcrew_fragment1_guest_layout,container,false);

        fbtn_createGuest = view.findViewById(R.id.fbtn_createGuest);

        fbtn_createGuest.setOnClickListener(view1 -> {
        Intent intent = new Intent(getActivity().getApplication(), GuestCrewInsertGuest.class);

//            intent.putExtra("id", id);

        startActivity(intent);
    });

        return view;
    }

}
