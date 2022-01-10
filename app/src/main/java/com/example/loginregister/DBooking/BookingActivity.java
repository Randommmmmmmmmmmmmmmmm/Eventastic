package com.example.loginregister.DBooking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.loginregister.R;
import com.example.loginregister.recyclerView.Booking;
import com.example.loginregister.recyclerView.adapter.bookingRecycleView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BookingActivity extends AppCompatActivity {

    int id;
    String username;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    List<Booking> allBookingInfor;
    public FloatingActionButton fbtn_createBooking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);



        if(savedInstanceState==null) {
            Bundle extra = getIntent().getExtras();
            id = extra.getInt("id");
            username = extra.getString("username");
        }else{
            id=(int)savedInstanceState.getSerializable("id");
            username=(String)savedInstanceState.getSerializable("username");
        }


        recyclerView = findViewById(R.id. recycler_view);

        linearLayoutManager = new LinearLayoutManager(BookingActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);


        allBookingInfor = getallBookingInfor();
//        try {
//            allBookingInfor = getallBookingInfor();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


        fbtn_createBooking =findViewById(R.id.fbtn_createBooking);

        fbtn_createBooking.setOnClickListener(new View.OnClickListener() {
            String name;
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BookingActivity.this, AddBookingDetail.class);

                intent.putExtra("id", id);
                intent.putExtra("username", username);
                System.out.println(id+"NAMA SAYA SHAMEER NAMA SAYA SHAMEER NAMA SAYA SHAMEERNAMA SAYA SHAMEER NAMA SAYA SHAMEERNAMA SAYA SHAMEERNAMA SAYA SHAMEERNAMA SAYA SHAMEERNAMA SAYA SHAMEERNAMA SAYA SHAMEER");
                startActivity(intent);



            }
        });
    }
    private List<Booking> getallBookingInfor()  {


        List<Booking> allBooking = new ArrayList<Booking>();
//        allBooking.add(new Booking(obj.getString("name"), obj.getString("category"), obj.getString("payment_status")));
//        allBooking.add(new Booking("name","category","payment_status"));
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
                data[0] = username;
                data[1] = "list";
                data[2] = String.valueOf(id);
                PutData putData = new PutData("http://192.168.43.16/API-Eventastic/Booking/BookingListView.php", "POST", field, data);

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
                                    allBooking.add(new Booking(obj.getString("booking_id"),obj.getString("event_id"),obj.getString("name"), obj.getString("category"),obj.getString("notes"),obj.getString("payment"), obj.getString("payment_status"), obj.getString("phone"), obj.getString("email")));
//                                    allBooking.add(new Booking("name","category","payment_status"));
//                                    Toast.makeText(getApplicationContext(),obj.getString("booking_id"), Toast.LENGTH_SHORT).show();
                                }
                                bookingRecycleView bookingRecycleView = new bookingRecycleView(BookingActivity.this,allBookingInfor,username);
                                recyclerView.setAdapter(bookingRecycleView);
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

        return allBooking;

    }
}