package com.example.mohitsaini.fragmentexample.part_3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.mohitsaini.fragmentexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohitsaini on 2/5/17.
 */

public class CustomListClickable extends AppCompatActivity {

    ListView listView;
    String[] list = {"Androidhive Retrofit Example", "AnonymousInner Class Example", "Async Task Example", "Blur Image",
            "Bluetooth Java T Point", "Bluetooth Tutorials Point", "Bluetooth Complete Example", "Calender With Only Future Date",
            "Customize List View", "Expendable List View", "Floating Button Example", "Floating Widget Example",
            "Fragment M", "Main Activity", "Main Activity 2", "Multilevel List", "EditTextCheckNull", "My JSON Example",
            "My Retrofit Example", "Navigation Drawer", "NotificationExample", "Picasso Example", "Picasso Simple",
            "Potrait Landscape Example", "Register Activity", "Retrofit Example", "Send Data Using Volley",
            "Swipe View With RecyclerView", "TabHost Example", "With RecyclerView"
    };

    CustomListClIckableAdapter mAdapter;
    List<String> mListData;
    List<CustomListModelClass> mainList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_json_example);

        listView = (ListView) findViewById(R.id.lv);
        mListData = new ArrayList<>();

        for (int i = 0; i < list.length; i++) {
            mListData.add(list[i]);
        }
        Log.e("FINAL DATA  = ", mListData.toString());
        for (int i=0; i < mListData.size(); i++) {
            CustomListModelClass customListModelClass = new CustomListModelClass();
            customListModelClass.setData(mListData.get(i));
            mainList.add(customListModelClass);
        }

        mAdapter = new CustomListClIckableAdapter(this, mainList);
        listView.setAdapter(mAdapter);

    }
}
