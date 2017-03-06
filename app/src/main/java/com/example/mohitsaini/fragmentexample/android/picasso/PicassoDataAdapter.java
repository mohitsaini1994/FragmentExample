package com.example.mohitsaini.fragmentexample.android.picasso;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohitsaini.fragmentexample.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by mohitsaini on 19/1/17.
 */

public class PicassoDataAdapter extends RecyclerView.Adapter<PicassoDataAdapter.ViewHolder>{

    private ArrayList<PicassoDataModel> picasso_data_model;
    private Context context;

    public PicassoDataAdapter(Context context,ArrayList<PicassoDataModel> picasso_data_model) {
        this.context = context;
        this.picasso_data_model = picasso_data_model;
    }

    @Override
    public PicassoDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.picasso_screen, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.picasso_title.setText(picasso_data_model.get(position).getTitle());
        Picasso.with(context).load(picasso_data_model.get(position).getImage_url()).into(holder.picasso_imageView);
    }

    @Override
    public int getItemCount() {
        return picasso_data_model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView picasso_title;
        ImageView picasso_imageView;
        public ViewHolder(View itemView) {
            super(itemView);

            picasso_title = (TextView)itemView.findViewById(R.id.picasso_title);
            picasso_imageView = (ImageView) itemView.findViewById(R.id.picasso_imageView);
        }
    }
}
