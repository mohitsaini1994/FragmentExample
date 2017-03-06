package com.example.mohitsaini.fragmentexample.part_1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohitsaini.fragmentexample.R;

import java.util.List;

/**
 * Created by mohitsaini on 31/12/16.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<Movie> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, email_id, mobile_no, department, designation;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tvv1);
            email_id = (TextView) view.findViewById(R.id.tvv2);
            mobile_no = (TextView) view.findViewById(R.id.tvv3);
            department = (TextView) view.findViewById(R.id.tvv4);
            designation = (TextView) view.findViewById(R.id.tvv5);
        }
    }

    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_single_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.name.setText(movie.getName());
        holder.email_id.setText(movie.getEmail_id());
        holder.mobile_no.setText(movie.getMobile_no());
        holder.department.setText(movie.getDepartment());
        holder.designation.setText(movie.getDesignation());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}