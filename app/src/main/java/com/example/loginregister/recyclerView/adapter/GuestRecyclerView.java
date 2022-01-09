package com.example.loginregister.recyclerView.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregister.R;
import com.example.loginregister.recyclerView.Guest;

import java.util.List;

public class GuestRecyclerView extends RecyclerView.Adapter<GuestRecyclerView.GuestViewHolder> {

    public List<Guest> GuestList;
    private Context context;

    public GuestRecyclerView(Context context, List<Guest> GuestList) {
        this.context=context;
        this.GuestList= GuestList;
    }

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View Guest_row = LayoutInflater.from(parent.getContext()).inflate(R.layout.guest_row,null);

        GuestViewHolder GuestVH = new GuestViewHolder(Guest_row);
        return GuestVH;
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder holder, int position) {

        holder.tv_name.setText(GuestList.get(position).getName());
        holder.tv_paymentStatus.setText(GuestList.get(position).getPaymentStatus());
    }

    @Override
    public int getItemCount() {
        return GuestList.size();
    }

    public class GuestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tv_name,tv_GuestBategory,tv_paymentStatus;


        public GuestViewHolder(@NonNull View itemView) {

            super(itemView);

            tv_name = itemView.findViewById(R.id. tv_name);
            tv_paymentStatus = itemView.findViewById(R.id.tv_paymentStatus);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Toast.makeText(view.getContext(),"Beverage Name: " + beverageList.get(getAdapterPosition()).getName(),Toast.LENGTH_SHORT).show();
//
//            Intent intent = new Intent(view.getContext(), InsertEventDetails.class);
//            intent.putExtra("GuestName", GuestList.get(getAdapterPosition()).getName());
//
//            view.getContext().startActivity(intent);
        }
    }
}
