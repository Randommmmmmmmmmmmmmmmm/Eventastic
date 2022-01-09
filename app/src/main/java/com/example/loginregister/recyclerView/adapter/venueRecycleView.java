package com.example.loginregister.recyclerView.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregister.recyclerView.Venue;
import com.example.loginregister.R;

import java.util.List;

public class venueRecycleView extends RecyclerView.Adapter<venueRecycleView.VenueViewHolder> {
    public List<Venue> venueList;
    private Context context;

    public venueRecycleView(Context context, List<Venue> venueList) {
        this.context=context;
        this.venueList= venueList;
    }

    @NonNull
    @Override
    public VenueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View venue_row = LayoutInflater.from(parent.getContext()).inflate(R.layout.venue_row,null);

        VenueViewHolder venueVH = new VenueViewHolder(venue_row);
        return venueVH;
    }

    @Override
    public void onBindViewHolder(@NonNull VenueViewHolder holder, int position) {

        holder.tv_vname.setText(venueList.get(position).getVname());
        holder.tv_vlocation.setText(venueList.get(position).getVlocation());
        holder.tv_vpayment.setText(venueList.get(position).getVpayment());
    }

    @Override
    public int getItemCount() {
        return venueList.size();
    }

    public class VenueViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tv_vname,tv_vlocation,tv_vpayment;


        public VenueViewHolder(@NonNull View itemView) {

            super(itemView);

            tv_vname = itemView.findViewById(R.id. tv_vname);
            tv_vlocation = itemView.findViewById(R.id. tv_vlocation);
            tv_vpayment = itemView.findViewById(R.id.tv_vpayment);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Toast.makeText(view.getContext(),"Beverage Name: " + beverageList.get(getAdapterPosition()).getName(),Toast.LENGTH_SHORT).show();
//
//            Intent intent = new Intent(view.getContext(), InsertEventDetails.class);
//            intent.putExtra("venueName", venueList.get(getAdapterPosition()).getName());
//
//            view.getContext().startActivity(intent);
        }
    }
}
