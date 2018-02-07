package com.example.naseem.newcardview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Naseem on 07-02-2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<App> mApps;
    private boolean mHorizontal;
    private boolean mPager;

    public Adapter(boolean horizontal,boolean pager,List<App> apps){
        mApps=apps;
        mHorizontal=horizontal;
        mPager=pager;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mPager){
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pager,parent,false));

        }else {
            return mHorizontal ? new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter,parent,false)):
            new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_vertical,parent,false));
        }

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        App app=mApps.get(position);
        holder.imageview.setImageResource(app.getDrawable());
        holder.nameTextview.setText(app.getName());
        holder.ratingTextview.setText(String.valueOf(app.getRating()));



    }

    @Override
    public int getItemViewType(int position){

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mApps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageview;
        public TextView nameTextview;
        public TextView ratingTextview;

        public ViewHolder(View itemView) {

            super(itemView);
            imageview=(ImageView)itemView.findViewById(R.id.imageview);
            nameTextview=(TextView) itemView.findViewById(R.id.nameTextview);
            ratingTextview=(TextView) itemView.findViewById(R.id.ratingTextview);

        }
    }
}
