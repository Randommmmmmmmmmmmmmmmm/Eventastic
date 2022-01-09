package com.example.loginregister.recyclerView.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregister.DBooking.AddBookingDetail;
import com.example.loginregister.recyclerView.Booking;
import com.example.loginregister.R;

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
        View booking_row = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_row,null);

        BookingViewHolder bookingVH = new BookingViewHolder(booking_row);
        return bookingVH;
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {

        holder.tv_name.setText(bookingList.get(position).getName());
        holder.tv_bookingBategory.setText(bookingList.get(position).getCategory());
        holder.tv_paymentStatus.setText(bookingList.get(position).getPayment_status());
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

    public class BookingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tv_name,tv_bookingBategory,tv_paymentStatus;


        public BookingViewHolder(@NonNull View itemView) {

            super(itemView);

            tv_name = itemView.findViewById(R.id. tv_name);
            tv_bookingBategory = itemView.findViewById(R.id. tv_bookingBategory);
            tv_paymentStatus = itemView.findViewById(R.id.tv_paymentStatus);

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
