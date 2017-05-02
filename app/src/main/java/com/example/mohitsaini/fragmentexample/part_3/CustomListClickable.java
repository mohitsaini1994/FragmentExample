package com.example.mohitsaini.fragmentexample.part_3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mohitsaini.fragmentexample.R;

import java.util.ArrayList;

/**
 * Created by mohitsaini on 2/5/17.
 */

public class CustomListClickable extends AppCompatActivity {

    ListView listView;
    String[] list = {"Androidhive Retrofit Example",
            "AnonymousInner Class Example",
            "Async Task Example",
            "Blur Image",
            "Bluetooth Java T Point",
            "Bluetooth Tutorials Point",
            "Bluetooth Complete Example",
            "Calender With Only Future Date",
            "Customize List View",
            "Expendable List View",
            "Floating Button Example",
            "Floating Widget Example",
            "Fragment M",
            "Main Activity",
            "Main Activity 2",
            "Multilevel List",
            "EditTextCheckNull",
            "My JSON Example",
            "My Retrofit Example",
            "Navigation Drawer",
            "NotificationExample",
            "Picasso Example",
            "Picasso Simple",
            "Potrait Landscape Example",
            "Register Activity",
            "Retrofit Example",
            "Send Data Using Volley",
            "Swipe View With RecyclerView",
            "TabHost Example",
            "With RecyclerView"};
    private CustomListClIckableAdapter mAdapter;
    private ArrayList<String> mListData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_json_example);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setVisibility(View.GONE);

        mListData = new ArrayList<>();
        listView = (ListView) findViewById(R.id.lv);
        mAdapter = new CustomListClIckableAdapter(this);
        for (int i = 0; i < list.length; i++) {
            mListData.add(list[i]);
        }
        mAdapter.setData(mListData);
        mAdapter.setListener(new CustomListClIckableAdapter.OnPairButtonClickListener() {
            @Override
            public void onPairButtonClick(int position) {
                Toast.makeText(CustomListClickable.this, "okkkkk[][][][][]", Toast.LENGTH_SHORT).show();
            }
        });
        listView.setAdapter(mAdapter);

    }
}
