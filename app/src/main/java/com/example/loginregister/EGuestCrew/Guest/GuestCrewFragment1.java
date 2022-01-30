package com.example.loginregister.EGuestCrew.Guest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import com.example.loginregister.recyclerView.adapter.GuestRecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
//GuestActivity
public class GuestCrewFragment1 extends Fragment {

    int id;
    String username;
    String type;
    FloatingActionButton fbtn_createGuest;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    List<Guest> allGuestInfor;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.eguestcrew_fragment1_guest_layout,container,false);

        if(savedInstanceState==null) {
            Bundle extra = getActivity().getIntent().getExtras();
            id = extra.getInt("id");
            username = extra.getString("username");
            type = extra.getString("type");
        }else{
            id=(int)savedInstanceState.getSerializable("id");
            username=(String)savedInstanceState.getSerializable("username");
            type=(String)savedInstanceState.getSerializable("type");
        }

        recyclerView = view.findViewById(R.id. recycler_view);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        allGuestInfor = getallGuestInfor();

        fbtn_createGuest = view.findViewById(R.id.fbtn_createGuest);

        fbtn_createGuest.setOnClickListener(view1 -> {
        Intent intent = new Intent(getActivity().getApplication(), GuestCrewInsertGuest.class);

            intent.putExtra("id", id);
            intent.putExtra("username", username);

        startActivity(intent);
    });

        return view;
    }

    private List<Guest> getallGuestInfor()  {


        List<Guest> allGuest = new ArrayList<Guest>();
//        allGuest.add(new Guest(obj.getString("name"), obj.getString("category"), obj.getString("payment_status")));
//        allGuest.add(new Guest("name","category","payment_status"));
        //letak putdata
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                String[] field = new String[4];
                field[0] = "username";
                field[1] = "process";
                field[2] = "event_id";
                field[3] = "type";

                //Creating array for data
                String[] data = new String[4];
                data[0] = username;
                data[1] = "list";
                data[2] = String.valueOf(id);
                data[3] = type;
                // todo host
//                PutData putData = new PutData("http://"+getString(R.string.localhost)+"/API-Eventastic/GuestCrew/guestListView.php", "POST", field, data);
                //lepak server
                PutData putData = new PutData("https://eventastic.lepak.xyz/GuestCrew/guestListView.php", "POST", field, data);

                if (putData.startPut()) {

                    if (putData.onComplete()) {
//                progressBar.setVisibility(View.GONE);
                        String result = putData.getResult();

                        if (!result.equals("500")) {

                            try {


//                                JSONObject json = new JSONObject(result);
//                                JSONArray array = json.getJSONArray("GetCitiesResult");

                                System.out.println(result);
                                JSONArray array = new JSONArray(result);


                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject obj = array.getJSONObject(i);
                                    allGuest.add(new Guest(obj.getInt("guest_id"),obj.getString("event_id"),obj.getString("name"), obj.getString("gender"),obj.getString("category"),obj.getString("quantity"),obj.getString("progress"),  obj.getString("phone"), obj.getString("email"), obj.getString("notes")));
//                                    allGuest.add(new Guest("name","category","payment_status"));
//                                    Toast.makeText(getApplicationContext(),obj.getString("Guest_id"), Toast.LENGTH_SHORT).show();
                                }
                                GuestRecyclerView GuestRecyclerView = new GuestRecyclerView(getContext(),allGuestInfor,username);
                                recyclerView.setAdapter(GuestRecyclerView);
//                                recyclerView.notify();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
//                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                        }
                    }
                }
//        allBeverage.add(new Beverage("Event 1"/**, R.drawable.flat_white**/));
            }
        });

        return allGuest;

    }
}
