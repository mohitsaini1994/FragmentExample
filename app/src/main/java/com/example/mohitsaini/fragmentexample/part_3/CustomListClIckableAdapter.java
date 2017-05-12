package com.example.mohitsaini.fragmentexample.part_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohitsaini.fragmentexample.R;

import java.util.List;

/**
 * Created by mohitsaini on 2/5/17.
 */

public class CustomListClIckableAdapter extends BaseAdapter {

    Context context;
    private List<CustomListModelClass> mainList;

    public CustomListClIckableAdapter(Context context, List<CustomListModelClass> mainList) {
        this.context = context;
        this.mainList = mainList;
    }

    @Override
    public int getCount() {
        return mainList.size();
    }

    @Override
    public Object getItem(int i) {
        return mainList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        final ViewHolder viewHolder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_row_clickable, null);

            viewHolder = new ViewHolder();

            viewHolder.click_image_change = (ImageView) view.findViewById(R.id.click_image_change);
            viewHolder.clickable_tv = (TextView) view.findViewById(R.id.clickable_tv);
            viewHolder.accept = (Button) view.findViewById(R.id.click_approve);
            viewHolder.decline = (Button) view.findViewById(R.id.click_decline);

            view.setTag(viewHolder);
            view.setTag(R.id.click_approve, viewHolder.accept);
            view.setTag(R.id.click_decline, viewHolder.decline);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        if (mainList.get(i).getIschecked().equals("true")) {
            viewHolder.click_image_change.setBackgroundResource(R.drawable.click_list_checked);
        } else if (mainList.get(i).getIschecked().equals("false")) {
            viewHolder.click_image_change.setBackgroundResource(R.drawable.click_list_unchecked);
        } else {
            viewHolder.click_image_change.setBackgroundResource(0);
        }

        viewHolder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainList.get(i).setIschecked("true");
                viewHolder.click_image_change.setBackgroundResource(R.drawable.click_list_checked);
            }
        });
        viewHolder.decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainList.get(i).setIschecked("false");
                viewHolder.click_image_change.setBackgroundResource(R.drawable.click_list_unchecked);
            }
        });
        viewHolder.accept.setTag(i);
        viewHolder.decline.setTag(i);

        viewHolder.clickable_tv.setText(mainList.get(i).getData());

        return view;
    }

    public class ViewHolder {
        private ImageView click_image_change;
        private TextView clickable_tv;
        private Button accept;
        private Button decline;
    }
}
