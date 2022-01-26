package com.example.loginregister.recyclerView.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginregister.R;
import com.example.loginregister.recyclerView.Ads;

import java.util.List;

public class adsRecycleView extends RecyclerView.Adapter<adsRecycleView.AdsViewHolder> {
    public List<Ads> adsList;
    private Context context;

    public adsRecycleView(Context context, List<Ads> adsList) {
        this.context=context;
        this.adsList= adsList;
    }

    @NonNull
    @Override
    public AdsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ads_row = LayoutInflater.from(parent.getContext()).inflate(R.layout.rads_row,null);

        AdsViewHolder adsVH = new AdsViewHolder(ads_row);
        return adsVH;
    }

    @Override
    public void onBindViewHolder(@NonNull AdsViewHolder holder, int position) {

        holder.tv_adsName.setText(adsList.get(position).getAname());
        holder.tv_adsCategory.setText(adsList.get(position).getAcategory());
        holder.tv_adsStatus.setText(adsList.get(position).getAstatus());
    }

    @Override
    public int getItemCount() {
        return adsList.size();
    }

    public class AdsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView tv_adsName,tv_adsCategory,tv_adsStatus;


        public AdsViewHolder(@NonNull View itemView) {

            super(itemView);

            tv_adsName = itemView.findViewById(R.id. tv_adsName);
            tv_adsCategory = itemView.findViewById(R.id. tv_adsCategory);
            tv_adsStatus = itemView.findViewById(R.id.tv_adsStatus);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Toast.makeText(view.getContext(),"Beverage Name: " + beverageList.get(getAdapterPosition()).getName(),Toast.LENGTH_SHORT).show();
//
//            Intent intent = new Intent(view.getContext(), InsertEventDetails.class);
//            intent.putExtra("adsName", adsList.get(getAdapterPosition()).getName());
//
//            view.getContext().startActivity(intent);
        }
    }
}

