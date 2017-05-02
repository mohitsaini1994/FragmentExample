package com.example.mohitsaini.fragmentexample.part_3;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.mohitsaini.fragmentexample.R;

import java.util.List;

/**
 * Created by mohitsaini on 2/5/17.
 */

public class CustomListClIckableAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<String> mData;
    private CustomListClIckableAdapter.OnPairButtonClickListener mListener;

    public CustomListClIckableAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<String> data) {
        mData = data;
    }

    public void setListener(CustomListClIckableAdapter.OnPairButtonClickListener listener) {
        mListener = listener;
    }

    public int getCount() {
        return (mData == null) ? 0 : mData.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        final CustomListClIckableAdapter.ViewHolder holder;

        if (convertView == null) {
            convertView			=  mInflater.inflate(R.layout.list_row_clickable, null);

            holder 				= new CustomListClIckableAdapter.ViewHolder();

            holder.clickable_tv		= (TextView) convertView.findViewById(R.id.clickable_tv);
            holder.accept = (Button) convertView.findViewById(R.id.click_approve);
            holder.decline = (Button) convertView.findViewById(R.id.click_decline);

            convertView.setTag(holder);
        } else {
            holder = (CustomListClIckableAdapter.ViewHolder) convertView.getTag();
        }

        String device	= mData.get(position);

        holder.clickable_tv.setText(device);
        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    holder.accept.setText("true");
                    mListener.onPairButtonClick(position);
                }
            }
        });
        holder.decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    holder.decline.setText("true");
                    mListener.onPairButtonClick(position);
                }
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView clickable_tv;
        Button accept, decline;
    }

    public interface OnPairButtonClickListener {
       void onPairButtonClick(int position);
    }
}
