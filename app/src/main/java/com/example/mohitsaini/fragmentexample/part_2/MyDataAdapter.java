package com.example.mohitsaini.fragmentexample.part_2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mohitsaini.fragmentexample.R;
import com.example.mohitsaini.fragmentexample.android.hive.retrofit.RetMovie;
import com.example.mohitsaini.fragmentexample.android.hive.retrofit.RetMoviesAdapter;

import java.util.List;

/**
 * Created by mohitsaini on 9/1/17.
 */

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.MovieViewHolder> {

    private List<MyPost> movies;
    private int rowLayout;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView tvv1;
        TextView tvv2;
        TextView tvv3;
        TextView tvv4;
        TextView tvv5;


        public MovieViewHolder(View v) {
            super(v);
            tvv1 = (TextView) v.findViewById(R.id.tvv1);
            tvv2 = (TextView) v.findViewById(R.id.tvv2);
            tvv3 = (TextView) v.findViewById(R.id.tvv3);
            tvv4 = (TextView) v.findViewById(R.id.tvv4);
            tvv5 = (TextView) v.findViewById(R.id.tvv5);
        }
    }

    public MyDataAdapter(List<MyPost> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MyDataAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MyDataAdapter.MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyDataAdapter.MovieViewHolder holder, final int position) {
        holder.tvv1.setText(movies.get(position).getName());
        holder.tvv2.setText(movies.get(position).getEmailId());
        holder.tvv3.setText(movies.get(position).getMobileNo());
        holder.tvv4.setText(movies.get(position).getDepartment());
        holder.tvv5.setText(movies.get(position).getDesignation());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


}
