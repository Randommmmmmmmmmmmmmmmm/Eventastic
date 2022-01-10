package com.example.loginregister.recyclerView.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregister.EGuestCrew.Crew.GuestCrewInsertCrew;
import com.example.loginregister.EGuestCrew.Guest.GuestCrewInsertGuest;
import com.example.loginregister.R;
import com.example.loginregister.recyclerView.Crew;
import com.example.loginregister.recyclerView.Guest;

import java.util.List;

public class CrewRecyclerView extends RecyclerView.Adapter<CrewRecyclerView.CrewViewHolder> {

    String username;
    public List<Crew> CrewList;
    private Context context;

    public CrewRecyclerView(Context context, List<Crew> CrewList,String username) {
        this.context=context;
        this.CrewList= CrewList;
        this.username = username;
    }

    @NonNull
    @Override
    public CrewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View Crew_row = LayoutInflater.from(parent.getContext()).inflate(R.layout.crew_row,null);

        CrewViewHolder CrewVH = new CrewViewHolder(Crew_row);
        return CrewVH;
    }

    @Override
    public void onBindViewHolder(@NonNull CrewViewHolder holder, int position) {

        holder.tv_nameCrew.setText(CrewList.get(position).getName());
        holder.tv_crewProgress.setText(CrewList.get(position).getProgress());
        holder.tv_crewQuantity.setText(CrewList.get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        return CrewList.size();
    }

    public class CrewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tv_nameCrew,tv_crewProgress,tv_crewQuantity;


        public CrewViewHolder(@NonNull View itemView) {

            super(itemView);

            tv_nameCrew = itemView.findViewById(R.id.tv_nameCrew);
            tv_crewProgress = itemView.findViewById(R.id.tv_crewProgress);
            tv_crewQuantity = itemView.findViewById(R.id.tv_crewQuantity);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Toast.makeText(view.getContext(),"Beverage Name: " + beverageList.get(getAdapterPosition()).getName(),Toast.LENGTH_SHORT).show();
            Crew currentCrew = CrewList.get(getAdapterPosition());
            Intent intent = new Intent(view.getContext(), GuestCrewInsertCrew.class);
            intent.putExtra("id", CrewList.get(getAdapterPosition()).getEvent_id());
            intent.putExtra("username", username);
            intent.putExtra("edit", currentCrew);

            view.getContext().startActivity(intent);
        }
    }
}
