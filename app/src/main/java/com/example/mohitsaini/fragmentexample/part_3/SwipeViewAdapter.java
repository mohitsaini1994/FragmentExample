package com.example.mohitsaini.fragmentexample.part_3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohitsaini.fragmentexample.R;

import java.util.ArrayList;

/**
 * Created by mohitsaini on 21/1/17.
 */

public class SwipeViewAdapter extends RecyclerView.Adapter<SwipeViewAdapter.ViewHolder> {
    private ArrayList countries;

    public SwipeViewAdapter(ArrayList countries) {
        this.countries = countries;
    }

    @Override
    public SwipeViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row_customize, viewGroup, false);
        return new SwipeViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SwipeViewAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_country.setText(""+countries.get(i));
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void addItem(String country) {
        countries.add(country);
        notifyItemInserted(countries.size());
    }

    public void removeItem(int position) {
        countries.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, countries.size());
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_country;
        public ViewHolder(View view) {
            super(view);

            ImageView i1 = (ImageView)view.findViewById(R.id.img);
            i1.setVisibility(View.GONE);
            ImageView i2 = (ImageView)view.findViewById(R.id.list_row_customize_arrow);
            i2.setVisibility(View.GONE);
            TextView t = (TextView)view.findViewById(R.id.txt);
            t.setVisibility(View.GONE);

            tv_country = (TextView)view.findViewById(R.id.list_row_customize_tv);
            tv_country.setVisibility(View.VISIBLE);
        }
    }
}