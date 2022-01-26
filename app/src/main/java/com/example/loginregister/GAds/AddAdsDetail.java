package com.example.loginregister.GAds;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginregister.R;
import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class AddAdsDetail extends AppCompatActivity {

    EditText et_adsName, et_adsNotes;
    RadioGroup rg_adsCategory, rg_Ads_status;
    RadioButton radioButtonAdsCategory,radioButtonAdsStatus;
    Button btn_saveChangesAds;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gactivity_add_ads_detail);

        et_adsName = findViewById(R.id.et_adsName);
        et_adsNotes = findViewById(R.id.et_adsNotes);

        btn_saveChangesAds = findViewById(R.id.btn_saveChangesAds);
        rg_adsCategory = findViewById(R.id.rg_adsCategory);
        rg_Ads_status = findViewById(R.id.rg_Ads_status);

        if(savedInstanceState==null) {
            Bundle extra = getIntent().getExtras();
            id = extra.getInt("id");
        }else{
            id=(int)savedInstanceState.getSerializable("id");
        }


        btn_saveChangesAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //for radio group

                String username, name, category, notes, adsStatus ;

                int radioIdAdsCategory = rg_adsCategory.getCheckedRadioButtonId();
                radioButtonAdsCategory = findViewById(radioIdAdsCategory);

                int radioIdAdsStatus = rg_Ads_status.getCheckedRadioButtonId();
                radioButtonAdsStatus = findViewById(radioIdAdsStatus);


//                username = String.valueOf(textInputEditTextUsername.getText());
                name = String.valueOf(et_adsName.getText());
                notes = String.valueOf(et_adsNotes.getText());
                category = String.valueOf(radioButtonAdsCategory.getText());
                adsStatus = String.valueOf(radioButtonAdsStatus.getText());



                if(!name.equals("") && !category.equals("") && !notes.equals("") && !adsStatus.equals("")) {
                    //Start ProgressBar first (Set visibility VISIBLE)
//                    progressBar.setVisibility(View.VISIBLE);
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[7];
                            field[0] = "name";
                            field[1] = "category";
                            field[2] = "notes";
                            field[3] = "status";
                            field[4] = "process";
                            field[5] = "username";
                            field[6] = "event_id";

                            //Creating array for data
                            String[] data = new String[7];
                            data[0] = name;
                            data[1] = category;
                            data[2] = notes;
                            data[3] = adsStatus;
                            data[4] = "insert";
                            data[5] = "fanae";
                            data[6] = String.valueOf(id);
                            PutData putData = new PutData("http://192.168.43.16/API-Eventastic/Ads/AdsListView.php", "POST", field, data);
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