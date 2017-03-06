package com.example.mohitsaini.fragmentexample.part_2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mohitsaini.fragmentexample.R;

/**
 * Created by mohitsaini on 16/1/17.
 */

public class CustomizeListView extends AppCompatActivity {

    ListView list;
    String[] web = {"Androidhive Retrofit Example",
            "AnonymousInner Class Example",
            "Async Task Example",
            "Customize List View",
            "Floating Button Example",
            "Main Activity",
            "Main Activity 2",
            "My JSON Example",
            "My Retrofit Example",
            "Notification Example",
            "Potrait Landscape Example",
            "Register Activity",
            "Retrofit Example",
            "Send Data Using Volley",
            "TabHost Example",
            "With RecyclerView"};

    Integer[] imageId = {
            R.mipmap.pc, R.mipmap.pc, R.mipmap.pc, R.mipmap.pc,
            R.mipmap.pc, R.mipmap.pc, R.mipmap.pc, R.mipmap.pc,
            R.mipmap.pc, R.mipmap.pc, R.mipmap.pc, R.mipmap.pc,
            R.mipmap.pc, R.mipmap.pc, R.mipmap.pc, R.mipmap.pc
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customize_list_view);
        list = (ListView) findViewById(R.id.list);

        CustomList adapter = new CustomList(CustomizeListView.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomizeListView.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
    }
}
