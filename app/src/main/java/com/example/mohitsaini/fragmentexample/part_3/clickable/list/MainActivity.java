package com.example.mohitsaini.fragmentexample.part_3.clickable.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.mohitsaini.fragmentexample.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<String> headingList;
    ListViewAdaptar adaptar;
    List<NewModel> tempList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_list_activity_main);

        listView = (ListView) findViewById(R.id.listView);
        headingList = new ArrayList<>();
        headingList.add("Sunday");
        headingList.add("Monday");
        headingList.add("Tuesday");
        headingList.add("Wednesday");
        headingList.add("Thursday");
        headingList.add("Friday");
        headingList.add("Saturday");
        headingList.add("January");
        headingList.add("Feb");
        headingList.add("March");
        headingList.add("April");
        headingList.add("May");
        headingList.add("June");
        headingList.add("July");
        headingList.add("August");
        headingList.add("September");
        headingList.add("October");
        headingList.add("November");
        headingList.add("December");

        Log.e("List", headingList.toString());
        for (int i = 0; i < headingList.size(); i++) {
            NewModel model = new NewModel();
            model.setHeading(headingList.get(i));
            model.setApprovedChecked(false);
            model.setDisapproveChecked(false);
            tempList.add(model);
        }

        adaptar = new ListViewAdaptar(this, tempList);
        listView.setAdapter(adaptar);
    }
}
