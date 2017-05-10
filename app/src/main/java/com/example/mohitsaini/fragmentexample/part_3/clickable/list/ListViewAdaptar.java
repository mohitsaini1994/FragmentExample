package com.example.mohitsaini.fragmentexample.part_3.clickable.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohitsaini.fragmentexample.R;

import java.util.List;

public class ListViewAdaptar extends BaseAdapter {

    private Context context;
    private List<NewModel> localList;

    public ListViewAdaptar(Context context, List<NewModel> tempList) {
        this.context = context;
        this.localList = tempList;
    }

    @Override
    public int getCount() {
        return localList.size();
    }

    @Override
    public Object getItem(int i) {
        return localList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        final holderClassClass holderClass;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.click_list_listitem, null);

            holderClass = new holderClassClass();

            holderClass.imageView = (ImageView) view.findViewById(R.id.imageView);
            holderClass.imageViewRight = (ImageView) view.findViewById(R.id.imageViewRight);
            holderClass.approve = (CheckBox) view.findViewById(R.id.check1);
            holderClass.disapprove = (CheckBox) view.findViewById(R.id.check2);
            holderClass.heading = (TextView) view.findViewById(R.id.heading);

            holderClass.approve.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    if (b) {
                        holderClass.disapprove.setChecked(false);
                        holderClass.imageView.setBackgroundResource(R.drawable.click_list_checked);
                        int getPosition = (Integer) compoundButton.getTag();  // Here we get the position that we have set for the checkbox using setTag.
                        localList.get(getPosition).setApprovedChecked(compoundButton.isChecked()); // Set the value of checkbox to maintain its state.
                    } else {
                        holderClass.imageView.setBackgroundResource(0);
                        int getPosition = (Integer) compoundButton.getTag();  // Here we get the position that we have set for the checkbox using setTag.
                        localList.get(getPosition).setApprovedChecked(compoundButton.isChecked());
                    }
                }
            });

            holderClass.disapprove.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                    if (b) {
                        holderClass.approve.setChecked(false);
                        holderClass.imageView.setBackgroundResource(R.drawable.click_list_unchecked);
                        int getPosition = (Integer) compoundButton.getTag();  // Here we get the position that we have set for the checkbox using setTag.
                        localList.get(getPosition).setDisapproveChecked(compoundButton.isChecked()); // Set the value of checkbox to maintain its state.
                    } else {
                        holderClass.imageView.setBackgroundResource(0);
                        int getPosition = (Integer) compoundButton.getTag();  // Here we get the position that we have set for the checkbox using setTag.
                        localList.get(getPosition).setDisapproveChecked(compoundButton.isChecked());
                    }
                }
            });

            view.setTag(holderClass);
            view.setTag(R.id.check1, holderClass.approve);
            view.setTag(R.id.check2, holderClass.disapprove);
        } else {
            holderClass = (holderClassClass) view.getTag();
        }
        holderClass.approve.setTag(i);
        holderClass.disapprove.setTag(i);// This line is important.

        holderClass.heading.setText(localList.get(i).getHeading());
        holderClass.approve.setChecked(localList.get(i).isApprovedChecked());
        holderClass.disapprove.setChecked(localList.get(i).isDisapproveChecked());

        return view;
    }

    public class holderClassClass {
        private ImageView imageView;
        private ImageView imageViewRight;
        private CheckBox approve;
        private CheckBox disapprove;
        private TextView heading;
    }
}