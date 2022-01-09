package com.example.loginregister.recyclerView.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregister.R;
import com.example.loginregister.recyclerView.Crew;

import java.util.List;

public class CrewRecyclerView extends RecyclerView.Adapter<CrewRecyclerView.CrewViewHolder> {

    public List<Crew> CrewList;
    private Context context;

    public CrewRecyclerView(Context context, List<Crew> CrewList) {
        this.context=context;
        this.CrewList= CrewList;
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

        holder.tv_name.setText(CrewList.get(position).getName());
        holder.tv_paymentStatus.setText(CrewList.get(position).getPaymentStatus());
    }

    @Override
    public int getItemCount() {
        return CrewList.size();
    }

    public class CrewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tv_name,tv_CrewBategory,tv_paymentStatus;


        public CrewViewHolder(@NonNull View itemView) {

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
//            intent.putExtra("CrewName", CrewList.get(getAdapterPosition()).getName());
//
//            view.getContext().startActivity(intent);
        }
    }
}
