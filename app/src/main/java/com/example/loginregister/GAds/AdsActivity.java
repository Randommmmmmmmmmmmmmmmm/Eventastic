package com.example.loginregister.GAds;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregister.R;
import com.example.loginregister.recyclerView.Ads;
import com.example.loginregister.recyclerView.adapter.adsRecycleView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AdsActivity extends AppCompatActivity {

    int id;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    List<Ads> allAdsInfor;
    FloatingActionButton fbtn_createAds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gactivity_ads);


        if(savedInstanceState==null) {
            Bundle extra = getIntent().getExtras();
            id = extra.getInt("id");
        }else{
            id=(int)savedInstanceState.getSerializable("id");
        }


        recyclerView = findViewById(R.id. recycler_view);

        linearLayoutManager = new LinearLayoutManager(AdsActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);


        allAdsInfor = getallAdsInfor();
//        try {
//            allAdsInfor = getallAdsInfor();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


        fbtn_createAds =findViewById(R.id.fbtn_createAds);

        fbtn_createAds.setOnClickListener(new View.OnClickListener() {
            String name;
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AdsActivity.this, AddAdsDetail.class);

                intent.putExtra("id", id);

                startActivity(intent);



            }
        });
    }
    private List<Ads> getallAdsInfor()  {


        List<Ads> allAds = new ArrayList<Ads>();
//        allAds.add(new Ads(obj.getString("name"), obj.getString("category"), obj.getString("status")));
//        allAds.add(new Ads("name","category","status"));
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
                PutData putData = new PutData("http://192.168.43.16/API-Eventastic/Ads/AdsListView.php", "POST", field, data);

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
                                    allAds.add(new Ads(obj.getString("name"), obj.getString("category"), obj.getString("status")));
//                                    allAds.add(new Ads("name","category","status"));
//                                    Toast.makeText(getApplicationContext(), String.valueOf(allAds.get(i)), Toast.LENGTH_SHORT).show();
                                }
                                adsRecycleView adsRecycleView = new adsRecycleView(AdsActivity.this,allAdsInfor);
                                recyclerView.setAdapter(adsRecycleView);
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

        return allAds;

    }
}
