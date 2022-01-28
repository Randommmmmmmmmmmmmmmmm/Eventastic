package com.example.loginregister.recyclerView.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregister.DBooking.AddBookingDetail;
import com.example.loginregister.DBooking.BookingActivity;
import com.example.loginregister.recyclerView.Booking;
import com.example.loginregister.R;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class bookingRecycleView extends RecyclerView.Adapter<bookingRecycleView.BookingViewHolder> {

    public List<Booking> bookingList;
    private Context context;
    String eventid;
    String username;

    public bookingRecycleView(Context context, List<Booking> bookingList,String username) {
        this.context=context;
        this.bookingList= bookingList;
        this.username = username;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View booking_row = LayoutInflater.from(parent.getContext()).inflate(R.layout.rbooking_row,null);

        BookingViewHolder bookingVH = new BookingViewHolder(booking_row);
        return bookingVH;

    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {

        holder.tv_name.setText(bookingList.get(position).getName());
        holder.tv_bookingBategory.setText(bookingList.get(position).getCategory());
        holder.tv_paymentStatus.setText(bookingList.get(position).getPayment_status());

        holder.button_delete_booking.setOnClickListener(view -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            // Set a title for alert dialog
            builder.setTitle("Select your answer.");

            // Ask the final question
            builder.setMessage("Are you sure to hide?");

            // Set the alert dialog yes button click listener
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
//
//                    Handler handler = new Handler();
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//
//                            String[] field = new String[3];
//                            field[0] = "username";
//                            field[1] = "process";
//                            field[2] = "event_id";
//
//                            //Creating array for data
//                            String[] data = new String[3];
//                            data[0] = username;
//                            data[1] = "list";
//                            data[2] = String.valueOf(id);
//                            PutData putData = new PutData("http://192.168.43.16/API-Eventastic/Booking/BookingListView.php", "POST", field, data);
//
//                            if (putData.startPut()) {
//
//                                if (putData.onComplete()) {
////                progressBar.setVisibility(View.GONE);
//                                    String result = putData.getResult();
//
//                                    if (!result.equals("500")) {
//
//                                        try {
//
//
////                                JSONObject json = new JSONObject(result);
////                                JSONArray array = json.getJSONArray("GetCitiesResult");
//
//                                            System.out.println(result);
//                                            JSONArray array = new JSONArray(result);
//
//
//                                            for (int i = 0; i < array.length(); i++) {
//                                                JSONObject obj = array.getJSONObject(i);
//                                                allBooking.add(new Booking(obj.getString("booking_id"),obj.getString("event_id"),obj.getString("name"), obj.getString("category"),obj.getString("notes"),obj.getString("payment"), obj.getString("payment_status"), obj.getString("phone"), obj.getString("email")));
////                                    allBooking.add(new Booking("name","category","payment_status"));
////                                    Toast.makeText(getApplicationContext(),obj.getString("booking_id"), Toast.LENGTH_SHORT).show();
//                                            }
//                                            bookingRecycleView bookingRecycleView = new bookingRecycleView(BookingActivity.this,allBookingInfor,username);
//                                            recyclerView.setAdapter(bookingRecycleView);
////                                recyclerView.notify();
//                                        } catch (JSONException e) {
//                                            e.printStackTrace();
//                                        }
//                                    } else {
////                            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            }
////        allBeverage.add(new Beverage("Event 1"/**, R.drawable.flat_white**/));
//                        }
//                    });
//
                }
            });

            // Set the alert dialog no button click listener
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AlertDialog dialog = builder.create();
            // Display the alert dialog on interface
            dialog.show();

        });
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    public class BookingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tv_name,tv_bookingBategory,tv_paymentStatus;
        public Button button_delete_booking;


        public BookingViewHolder(@NonNull View itemView) {

            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_nameCrew);
            tv_bookingBategory = itemView.findViewById(R.id.tv_crewProgress);
            tv_paymentStatus = itemView.findViewById(R.id.tv_crewQuantity);
            button_delete_booking = itemView.findViewById(R.id.button_delete_booking);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Toast.makeText(view.getContext(),"Beverage Name: " + beverageList.get(getAdapterPosition()).getName(),Toast.LENGTH_SHORT).show();
//
            Booking currentBooking = bookingList.get(getAdapterPosition());
            Intent intent = new Intent(view.getContext(), AddBookingDetail.class);
            intent.putExtra("id", bookingList.get(getAdapterPosition()).getEventid());
            intent.putExtra("username", username);
            intent.putExtra("edit", currentBooking);
//            intent.putExtra("bookingName", bookingList.get(getAdapterPosition()).getName());

            view.getContext().startActivity(intent);
        }
    }
}
