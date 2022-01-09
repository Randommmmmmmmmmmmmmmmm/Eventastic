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

import com.example.loginregister.EGuestCrew.GuestCrewInsertCrew;
import com.example.loginregister.R;
import com.example.loginregister.recyclerView.Crew;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GuestCrewFragment2 extends Fragment {

    FloatingActionButton fbtn_createCrew;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    List<Crew> allCrewInfor;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.guestcrew_fragment2_crew_layout,container,false);

        recyclerView = view.findViewById(R.id. recycler_view);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        allCrewInfor = getallCrewInfor();

        fbtn_createCrew = view.findViewById(R.id.fbtn_createCrew);

        fbtn_createCrew.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity().getApplication(), GuestCrewInsertCrew.class);

//            intent.putExtra("id", id);

            startActivity(intent);
        });

        return view;
    }

    private List<Crew> getallCrewInfor()  {


        List<Crew> allCrew = new ArrayList<Crew>();
////        allCrew.add(new Crew(obj.getString("name"), obj.getString("category"), obj.getString("payment_status")));
////        allCrew.add(new Crew("name","category","payment_status"));
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
//                PutData putData = new PutData("http://192.168.43.16/API-Eventastic/Crew/CrewListView.php", "POST", field, data);
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
//                                    allCrew.add(new Crew(obj.getString("name"), obj.getString("category"), obj.getString("payment_status")));
////                                    allCrew.add(new Crew("name","category","payment_status"));
////                                    Toast.makeText(getApplicationContext(), String.valueOf(allCrew.get(i)), Toast.LENGTH_SHORT).show();
//                                }
//                                CrewRecyclerView CrewRecyclerView = new CrewRecyclerView(CrewActivity.this,allCrewInfor);
//                                recyclerView.setAdapter(CrewRecyclerView);
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
        return allCrew;

    }
}
