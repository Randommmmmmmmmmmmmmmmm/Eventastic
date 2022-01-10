package com.example.loginregister.FVenue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.loginregister.R;
import com.example.loginregister.recyclerView.Venue;
import com.example.loginregister.recyclerView.adapter.venueRecycleView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VenueActivity extends AppCompatActivity {

    int id;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    List<Venue> allVenueInfor;
    Button fbtn_info;
    FloatingActionButton fbtn_createVenue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue);

        fbtn_info = findViewById(R.id.buttonVenueList);
        fbtn_createVenue = findViewById(R.id.fbtn_createVenue);

        if(savedInstanceState==null) {
            Bundle extra = getIntent().getExtras();
            id = extra.getInt("id");
        }else{
            id=(int)savedInstanceState.getSerializable("id");
        }


        recyclerView = findViewById(R.id. recycler_view);

        linearLayoutManager = new LinearLayoutManager(VenueActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);


        allVenueInfor = getallVenueInfor();
//        try {
//            allVenueInfor = getallVenueInfor();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


        fbtn_createVenue.setOnClickListener(new View.OnClickListener() {
            String name;
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(VenueActivity.this, AddVenueDetail.class);

                intent.putExtra("id", id);

                startActivity(intent);



            }
        });

        fbtn_info.setOnClickListener(new View.OnClickListener() {
            String name;
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(VenueActivity.this, VenueList.class);

                intent.putExtra("id", id);

                startActivity(intent);



            }
        });
    }
    private List<Venue> getallVenueInfor()  {


        List<Venue> allVenue = new ArrayList<Venue>();
//        allVenue.add(new Venue(obj.getString("name"), obj.getString("location"), obj.getString("payment_status")));
//        allVenue.add(new Venue("name","location","payment_status"));
        //letak putdata
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                String[] field = new String[3];
                field[0] = "username";
                field[1] = "process";
                field[2] = "event_id";

                //Creating array for data
                String[] data = new String[3];
                data[0] = "fanae";
                data[1] = "list";
                data[2] = String.valueOf(id);
                PutData putData = new PutData("http://192.168.0.145/API-Eventastic/Venue/VenueListView.php", "POST", field, data);

                if (putData.startPut()) {

                    if (putData.onComplete()) {
//                progressBar.setVisibility(View.GONE);
                        String result = putData.getResult();

                        if (!result.equals("500")) {

                            try {


//                                JSONObject json = new JSONObject(result);
//                                JSONArray array = json.getJSONArray("GetCitiesResult");
                                JSONArray array = new JSONArray(result);

                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject obj = array.getJSONObject(i);
                                    allVenue.add(new Venue(obj.getString("name"), obj.getString("location"), obj.getString("payment_status")));
//                                    allVenue.add(new Venue("name","location","payment_status"));
//                                    Toast.makeText(getApplicationContext(), String.valueOf(allVenue.get(i)), Toast.LENGTH_SHORT).show();
                                }
                                venueRecycleView venueRecycleView = new venueRecycleView(VenueActivity.this,allVenueInfor);
                                recyclerView.setAdapter(venueRecycleView);
//                                recyclerView.notify();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                        }
                    }
                }
//        allBeverage.add(new Beverage("Event 1"/**, R.drawable.flat_white**/));
            }
        });

        return allVenue;

    }
}