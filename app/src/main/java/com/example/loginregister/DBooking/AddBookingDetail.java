package com.example.loginregister.DBooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.loginregister.R;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

//choottt tapi tak boleh run emulator sebab tak boleh login
//tak dpt check rupa interface
//tak dpt link button
//db tak function lagi
public class AddBookingDetail extends AppCompatActivity {

    TextInputEditText et_bookingName, it_notes, it_payment, it_bookingContactPhoneNumber,it_bookingContactEmail;
    RadioGroup rg_bookingCategory, rg_Payment_status;
    RadioButton radioButtonCategory,radioButtonPaymentStatus;
    Button btn_saveChanges;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_booking_detail);

        et_bookingName = findViewById(R.id.et_bookingName);
        it_notes = findViewById(R.id.it_notes);
        it_payment = findViewById(R.id.it_payment);
        it_bookingContactPhoneNumber = findViewById(R.id.it_bookingContactPhoneNumber);
        it_bookingContactEmail = findViewById(R.id.it_bookingContactEmail);
        btn_saveChanges = findViewById(R.id.btn_saveChangesGuest);
        rg_bookingCategory = findViewById(R.id.rg_bookingCategory);
        rg_Payment_status = findViewById(R.id.rg_Payment_status);

        if(savedInstanceState==null) {
            Bundle extra = getIntent().getExtras();
            id = extra.getInt("id");
        }else{
            id=(int)savedInstanceState.getSerializable("id");
        }


        btn_saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //for radio group

                String username, name, category, notes, payment, paymentStatus, phone, email ;

                int radioIdCategory = rg_bookingCategory.getCheckedRadioButtonId();
                radioButtonCategory = findViewById(radioIdCategory);

                int radioIdPaymentStatus = rg_Payment_status.getCheckedRadioButtonId();
                radioButtonPaymentStatus = findViewById(radioIdPaymentStatus);


//                username = String.valueOf(textInputEditTextUsername.getText());
                name = String.valueOf(et_bookingName.getText());
                notes = String.valueOf(it_notes.getText());
                phone = String.valueOf(it_bookingContactPhoneNumber.getText());
                email = String.valueOf(it_bookingContactEmail.getText());
                payment = String.valueOf(it_payment.getText());
                category = String.valueOf(radioButtonCategory.getText());
                paymentStatus = String.valueOf(radioButtonPaymentStatus.getText());



                if(!name.equals("") && !category.equals("") && !notes.equals("") && !payment.equals("") && !paymentStatus.equals("") ) {
                    //Start ProgressBar first (Set visibility VISIBLE)
//                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[10];
                            field[0] = "name";
                            field[1] = "category";
                            field[2] = "notes";
                            field[3] = "payment";
                            field[4] = "payment_status";
                            field[5] = "phone";
                            field[6] = "email";
                            field[7] = "process";
                            field[8] = "username";
                            field[9] = "event_id";

                            //Creating array for data
                            String[] data = new String[10];
                            data[0] = name;
                            data[1] = category;
                            data[2] = notes;
                            data[3] = payment;
                            data[4] = paymentStatus;
                            data[5] = phone;
                            data[6] = email;
                            data[7] = "insert";
                            data[8] = "fanae";
                            data[9] = String.valueOf(id);
                            PutData putData = new PutData("http://192.168.43.16/API-Eventastic/Booking/BookingListView.php", "POST", field, data);
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