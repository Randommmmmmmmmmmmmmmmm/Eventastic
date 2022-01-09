package com.example.loginregister.EGuestCrew;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregister.R;
import com.example.loginregister.recyclerView.Guest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GuestCrewFragment1 extends Fragment {

    FloatingActionButton fbtn_createGuest;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    List<Guest> allGuestInfor;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.guestcrew_fragment1_guest_layout,container,false);

        recyclerView = view.findViewById(R.id. recycler_view);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        allGuestInfor = getallGuestInfor();

        fbtn_createGuest = view.findViewById(R.id.fbtn_createGuest);

        fbtn_createGuest.setOnClickListener(view1 -> {
        Intent intent = new Intent(getActivity().getApplication(), GuestCrewInsertGuest.class);

//            intent.putExtra("id", id);

        startActivity(intent);
    });

        return view;
    }

    private List<Guest> getallGuestInfor()  {


        List<Guest> allGuest = new ArrayList<Guest>();
////        allGuest.add(new Guest(obj.getString("name"), obj.getString("category"), obj.getString("payment_status")));
////        allGuest.add(new Guest("name","category","payment_status"));
//        //letak putdata
//        Handler handler = new Handler();
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//
//                String[] field = new String[3];
//                field[0] = "username";
//                field[1] = "process";
//                field[2] = "event_id";
//
//                //Creating array for data
//                String[] data = new String[3];
//                data[0] = "fanae";
//                data[1] = "list";
//                data[2] = String.valueOf(id);
//                PutData putData = new PutData("http://192.168.43.16/API-Eventastic/Guest/GuestListView.php", "POST", field, data);
//
//                if (putData.startPut()) {
//
//                    if (putData.onComplete()) {
////                progressBar.setVisibility(View.GONE);
//                        String result = putData.getResult();
//
//                        if (!result.equals("500")) {
//
//                            try {
//
//
////                                JSONObject json = new JSONObject(result);
////                                JSONArray array = json.getJSONArray("GetCitiesResult");
//                                JSONArray array = new JSONArray(result);
//
//                                for (int i = 0; i < array.length(); i++) {
//                                    JSONObject obj = array.getJSONObject(i);
//                                    allGuest.add(new Guest(obj.getString("name"), obj.getString("category"), obj.getString("payment_status")));
////                                    allGuest.add(new Guest("name","category","payment_status"));
////                                    Toast.makeText(getApplicationContext(), String.valueOf(allGuest.get(i)), Toast.LENGTH_SHORT).show();
//                                }
//                                GuestRecyclerView GuestRecyclerView = new GuestRecyclerView(GuestActivity.this,allGuestInfor);
//                                recyclerView.setAdapter(GuestRecyclerView);
////                                recyclerView.notify();
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        } else {
//                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
////        allBeverage.add(new Beverage("Event 1"/**, R.drawable.flat_white**/));
//            }
//        });
//
        return allGuest;

    }
}
