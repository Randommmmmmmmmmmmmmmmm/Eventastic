package com.example.loginregister.FVenue;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginregister.R;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class AddVenueDetail extends AppCompatActivity {

    TextInputEditText et_venueName, et_venueLocation, et_venueNotes, et_venuePayment, et_venuePhoneNumber, et_venueEmail, et_venueAddress;
    RadioGroup rg_Payment_status;
    RadioButton radioButtonPaymentStatus;
    Button btn_saveChangesVenue;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_venue_detail);

        et_venueName = findViewById(R.id.et_venueName);
        et_venueLocation = findViewById(R.id.et_venueLocation);
        et_venueNotes = findViewById(R.id.et_venueNotes);
        et_venuePayment = findViewById(R.id.et_venuePayment);
        et_venuePhoneNumber = findViewById(R.id.et_venuePhoneNumber);
        et_venueEmail = findViewById(R.id.et_venueEmail);
        et_venueAddress = findViewById(R.id.et_venueAddress);
        btn_saveChangesVenue = findViewById(R.id.btn_saveChangesVenue);
        rg_Payment_status = findViewById(R.id.rg_Payment_status);

        if(savedInstanceState==null) {
            Bundle extra = getIntent().getExtras();
            id = extra.getInt("id");
        }else{
            id=(int)savedInstanceState.getSerializable("id");
        }


        btn_saveChangesVenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //for radio group

                String username, vname, vlocation, vnotes, vpayment, vpaymentStatus, vphone, vemail, vaddress;


                int radioIdPaymentStatus = rg_Payment_status.getCheckedRadioButtonId();
                radioButtonPaymentStatus = findViewById(radioIdPaymentStatus);


//                username = String.valueOf(textInputEditTextUsername.getText());
                vname = String.valueOf(et_venueName.getText());
                vlocation = String.valueOf(et_venueLocation.getText());
                vnotes = String.valueOf(et_venueNotes.getText());
                vpayment = String.valueOf(et_venuePayment.getText());
                vphone = String.valueOf(et_venuePhoneNumber.getText());
                vemail = String.valueOf(et_venueEmail.getText());
                vaddress = String.valueOf(et_venueAddress.getText());
                vpaymentStatus = String.valueOf(radioButtonPaymentStatus.getText());



                if(!vname.equals("") && !vlocation.equals("") && !vnotes.equals("") && !vpayment.equals("") && !vpaymentStatus.equals("") ) {
                    //Start ProgressBar first (Set visibility VISIBLE)
//                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[11];
                            field[0] = "name";
                            field[1] = "location";
                            field[2] = "notes";
                            field[3] = "payment";
                            field[4] = "payment_status";
                            field[5] = "phone";
                            field[6] = "email";
                            field[7] = "address";
                            field[8] = "process";
                            field[9] = "username";
                            field[10] = "event_id";

                            //Creating array for data
                            String[] data = new String[11];
                            data[0] = vname;
                            data[1] = vlocation;
                            data[2] = vnotes;
                            data[3] = vpayment;
                            data[4] = vpaymentStatus;
                            data[5] = vphone;
                            data[6] = vemail;
                            data[7] = vaddress;
                            data[8] = "insert";
                            data[9] = "fanae";
                            data[10] = String.valueOf(id);
                            PutData putData = new PutData("http://192.168.0.145/API-Eventastic/Venue/VenueListView.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
//                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    if(result.equals("200")){

//                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        finish();

                                    }else{
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(), "All fields required",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//
}