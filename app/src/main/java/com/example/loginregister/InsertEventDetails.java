package com.example.loginregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.loginregister.adapter.bookingRecycleView;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InsertEventDetails extends AppCompatActivity {

    TextInputEditText eventName,eventDate,eventTime,eventBudget;
    Button buttonSaveChanges;

    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_event_details);


        eventName =findViewById(R.id.eventName);
        eventDate =findViewById(R.id.eventDate);
        eventTime =findViewById(R.id.eventTime);
        eventBudget =findViewById(R.id.eventBudget);
        buttonSaveChanges =findViewById(R.id.buttonSaveChanges);

        if(savedInstanceState==null) {
            Bundle extra = getIntent().getExtras();

            id = extra.getInt("event_id");
        }else{
            id=(int)savedInstanceState.getSerializable("event_id");
        }
//        Toast.makeText(getApplicationContext(), ""+id, Toast.LENGTH_LONG).show();
        fetchInfo();



        buttonSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),BeverageDetailActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("event_name", eventName.getText().toString());
                intent.putExtra("event_date", eventDate.getText().toString());
                intent.putExtra("event_time", eventTime.getText().toString());
                intent.putExtra("event_budget", eventBudget.getText().toString());
                startActivity(intent);
            }
        });
    }

    protected void fetchInfo(){

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
                PutData putData = new PutData("http://172.20.10.13/API-Eventastic/Event/updateEvent.php", "POST", field, data);

                if (putData.startPut()) {

                    if (putData.onComplete()) {
//                progressBar.setVisibility(View.GONE);
                        String result = putData.getResult();

                        if (!result.equals("500")) {

                            try {


                                JSONObject json = new JSONObject(result);
                                eventName.setText(json.getString("event_name"));
                                eventDate.setText(json.getString("event_date"));
                                eventTime.setText(json.getString("event_time"));
                                eventBudget.setText(json.getString("event_budget"));

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


    }




    }
