package com.example.loginregister.recyclerView.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregister.EGuestCrew.Guest.GuestCrewInsertGuest;
import com.example.loginregister.R;
import com.example.loginregister.recyclerView.Guest;

import java.util.List;

public class GuestRecyclerView extends RecyclerView.Adapter<GuestRecyclerView.GuestViewHolder> {

    public List<Guest> GuestList;
    private Context context;
    String username;

    public GuestRecyclerView(Context context, List<Guest> GuestList,String username) {
        this.context=context;
        this.GuestList= GuestList;
        this.username= username;
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

        holder.tv_nameGuest.setText(GuestList.get(position).getName());
        holder.tv_guestInvitation.setText(GuestList.get(position).getProgress());
        holder.tv_guestQuantity.setText(GuestList.get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        return GuestList.size();
    }

    public class GuestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tv_nameGuest,tv_guestInvitation,tv_guestQuantity;


        public GuestViewHolder(@NonNull View itemView) {

            super(itemView);

            tv_nameGuest = itemView.findViewById(R.id.tv_nameCrew);
            tv_guestInvitation = itemView.findViewById(R.id.tv_crewProgress);
            tv_guestQuantity = itemView.findViewById(R.id.tv_crewQuantity);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Toast.makeText(view.getContext(),"Beverage Name: " + beverageList.get(getAdapterPosition()).getName(),Toast.LENGTH_SHORT).show();
//
            Guest currentGuest = GuestList.get(getAdapterPosition());
            Intent intent = new Intent(view.getContext(), GuestCrewInsertGuest.class);
            intent.putExtra("id", GuestList.get(getAdapterPosition()).getEventid());
            intent.putExtra("username", username);
            intent.putExtra("edit", currentGuest);

            view.getContext().startActivity(intent);
        }
    }
}
