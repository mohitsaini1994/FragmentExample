package com.example.mohitsaini.fragmentexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mohitsaini.fragmentexample.R;

/**
 * Created by mohitsaini on 31/12/16.
 */

public class MainList extends AppCompatActivity {

    String[] list = {"Androidhive Retrofit Example",
            "AnonymousInner Class Example",
            "Async Task Example",
            "Atul List Clickable",
            "Blur Image",
            "Bluetooth Java T Point",
            "Bluetooth Tutorials Point",
            "Bluetooth Complete Example",
            "Calender With Only Future Date",
            "Custom List Clickable",
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

    String[] list_going = {"android.hive.retrofit.RetMainActivity",
            "part_1.AnonymousInnerClassExample",
            "part_2.AsyncTaskExample",
            "part_3.clickable.list.MainActivity",
            "part_3.BlurImage",
            "android.bluetooth.Bluetoothjavatpoint",
            "android.bluetooth.BluetoothTutorialsPoint",
            "android.bluetooth.complete.MainActivity",
            "part_3.CalenderWithOnlyFutureDate",
            "part_3.CustomListClickable",
            "part_2.CustomizeListView",
            "part_2.ExpendableListView",
            "part_1.FloatingButtonExample",
            "part_3.FloatingWidgetExample",
            "android.fragment.m.FragmentM",
            "part_1.MainActivity",
            "part_1.MainActivity2",
            "android.multilevel.listview.MultilevelList",
            "part_3.EditTextCheckNull",
            "part_1.MyJSONExample",
            "part_2.MyRetrofitExample",
            "part_3.NavigationDrawer",
            "part_2.NotificationExample",
            "android.picasso.PicassoExample",
            "android.picasso.PicassoSimple",
            "part_2.PotraitLandscapeExample",
            "part_1.RegisterActivity",
            "part_2.RetrofitExample",
            "android.learn2crack.send.MainActivity",
            "part_3.SwipeViewWithRecyclerView",
            "part_1.TabHostExample",
            "part_1.WithRecyclerView"};
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_json_example);
        listView = (ListView)findViewById(R.id.lv);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setVisibility(View.GONE);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,
                list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent("com.example.mohitsaini.fragmentexample."+list_going[i]);
                startActivity(intent);
            }
        });
    }
}
